package com.scut.blockchain.Controller;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.scut.blockchain.AutoConfig.Web3jConfig;
import com.scut.blockchain.Constants.ConnectConstants;
import com.scut.blockchain.Constants.GasConstants;
import com.scut.blockchain.Contracts.*;
import com.scut.blockchain.Mapper.EnterpriseMapper;
import com.scut.blockchain.Mapper.TransMapper;
import com.scut.blockchain.Mapper.UserMapper;
import com.scut.blockchain.Pojo.Trans;
import com.scut.blockchain.Pojo.User;
import com.scut.blockchain.Result;
import com.scut.blockchain.Utils;
import jnr.ffi.annotations.In;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.fisco.bcos.channel.client.Service;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.fisco.bcos.web3j.tuples.generated.Tuple2;
import org.fisco.bcos.web3j.tuples.generated.Tuple4;
import org.fisco.bcos.web3j.tx.Contract;
import org.fisco.bcos.web3j.tx.gas.StaticGasProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class Controller {
    @Autowired
    Web3j web3j;
    @Autowired
    Credentials credentials;
    @Autowired
    QAQ contra;
    @Autowired
    UserMapper userMapper;
    @Autowired
    EnterpriseMapper enterpriseMapper;
    @Autowired
    TransMapper transMapper;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd.HH:mm");
    Logger logger = Logger.getLogger(Controller.class);
    //AllContracts allContracts = AllContracts.getContracts();


    //    @RequestMapping(value = "api/hello")
//    public String Hello() throws Exception{
//        Web3j web3j= Web3jConfig.getWeb3j(service);
//        //通过Web3j对象调用API接口getBlockNumber
//        BigInteger blockNumber = web3j.getBlockNumber().send().getBlockNumber();
//        return blockNumber.toString();
//    }
//    @RequestMapping(value = "api/deploySchool")
//    public String deploySchool() throws Exception {
//        Web3j web3j= Web3jConfig.getWeb3j(service);
//        allContracts.setSchool(School.deploy(web3j,credentials,new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT), Lists.newArrayList("0xf6d30257e43ac97d10de2bb009195bd7b11413d2")).send());
//        School school=allContracts.getSchool();
//        return "部署School成功,合约地址为："+school.getContractAddress();
//    }
//    @RequestMapping(value = "api/addStudent")
//    public String addStudent(@RequestParam("name") String name,@RequestParam("age") int age,@RequestParam("grade") int grade,@RequestParam("class") int classes) throws Exception {
//        School school=allContracts.getSchool();
//        TransactionReceipt transactionReceipt=school.setStudent(name,BigInteger.valueOf(age),BigInteger.valueOf(grade),BigInteger.valueOf(classes)).send();
//        if(!transactionReceipt.getStatus().equals("0x0")){
//            return "你不是老师，无法添加学生，添加失败";
//        }
//        return "成功添加学生"+name+"交易哈希为："+transactionReceipt.getTransactionHash();
//    }
//    @RequestMapping(value = "api/getStudent")
//    public String addStudent(@RequestParam String name) throws Exception {
//        School school=allContracts.getSchool();
//        Tuple4 res;
//        res=school.getStudent(name).send();
//        List<String> names= (List<String>) res.getValue1();
//        List<BigInteger> age= (List<BigInteger>) res.getValue2();
//        List<BigInteger> grade= (List<BigInteger>) res.getValue3();
//        List<BigInteger> classes= (List<BigInteger>) res.getValue4();
//        if(names.isEmpty()){
//            return "没有查找到该学生";
//        }
//        String result="成功查找到"+names.size()+"名为"+names.get(0)+"的学生\n";
//        for(int i=0;i<names.size();i++){
//            result+="学生"+(i+1)+"\n";
//            result+="年龄："+age.get(i)+"\n";
//            result+="班级："+grade.get(i)+"年级"+classes.get(i)+"班\n";
//        }
//        return "<pre>"+result+"</pre>";
//    }
//    @RequestMapping(value = "api/deploySchool_crud")
//    public String deploySchool_crud() throws Exception {
//        Web3j web3j= Web3jConfig.getWeb3j(service);
//        allContracts.setSchool_crud(School_crud.deploy(web3j,credentials,new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT), Lists.newArrayList("0xf6d30257e43ac97d10de2bb009195bd7b11413d1")).send());
//        School_crud school_crud=allContracts.getSchool_crud();
//        return "部署School_crud成功,合约地址为："+school_crud.getContractAddress();
//    }
//    @RequestMapping(value = "api/addStudent_crud")
//    public String addStudent_crud(@RequestParam("name") String name,@RequestParam("age") int age,@RequestParam("grade") int grade,@RequestParam("class") int classes) throws Exception {
//        School_crud school_crud=allContracts.getSchool_crud();
//        TransactionReceipt transactionReceipt=school_crud.setStudent(name,BigInteger.valueOf(age),BigInteger.valueOf(grade),BigInteger.valueOf(classes)).send();
//        if(!transactionReceipt.getStatus().equals("0x0")){
//            return "添加失败";
//        }
//        return "成功添加学生"+name+"交易哈希为："+transactionReceipt.getTransactionHash();
//    }
//    @RequestMapping(value = "api/getStudent_crud")
//    public String addStudent_crud(@RequestParam String name) throws Exception {
//        School_crud school_crud=allContracts.getSchool_crud();
//        Tuple4 res;
//        res=school_crud.getStudent(name).send();
//        List<String> names= (List<String>) res.getValue1();
//        List<BigInteger> age= (List<BigInteger>) res.getValue2();
//        List<BigInteger> grade= (List<BigInteger>) res.getValue3();
//        List<BigInteger> classes= (List<BigInteger>) res.getValue4();
//        if(names.isEmpty()){
//            return "没有查找到该学生";
//        }
//        String result="成功查找到"+names.size()+"名为"+names.get(0)+"的学生\n";
//            for(int i=0;i<names.size();i++){
//                result+="学生"+(i+1)+"\n";
//                result+="年龄："+age.get(i)+"\n";
//                result+="班级："+grade.get(i)+"年级"+classes.get(i)+"班\n";
//        }
//        return "<pre>"+result+"</pre>";
//    }
    public boolean loginP(String id, String password) throws Exception {
        String res = userMapper.getPassword(id);
        return password.equals(res);
    }


    //注册
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Result register(@RequestBody Map<String, String> info) throws Exception {
        String id = info.get("id");
        String password = info.get("password");
        String cardNumber = info.get("card_number");
        String telNumber = info.get("tel_number");
        String address = info.get("address");
        if (userMapper.getPassword(id) != null) {
            return new Result(1);
        }
        contra.newAccount(id).send();
        User user = new User(Utils.geneId(), id, password, cardNumber, telNumber, address);
        userMapper.createUser(user);
        return new Result(3);
    }

    //用户积分查询
    @RequestMapping(value = "/showscoreP", method = RequestMethod.GET)
    public Result showscoreP(@RequestParam("id") String id, @RequestParam("password") String password) throws Exception {
        if(!loginP(id,password)){
            return new Result(1);
        }
        Tuple2<byte[], BigInteger> rest_score=contra.findChainTable(id).send();
        Result res=new Result(3);
        res.setScore_number(rest_score.getValue2().toString());
        return res;
    }

    //用户积分转赠
    @RequestMapping(value = "/presentscore", method = RequestMethod.POST)
    public Result presentscore(@RequestBody Map<String, String> info) throws Exception {
        logger.info(info);
        String yourId = info.get("yourid");
        String password = info.get("password");
        String friendId = info.get("friendid");
        String scoreNumber = info.get("score_number");
        if (!loginP(yourId, password)) {
            return new Result(1);
        }
        Tuple2<byte[], BigInteger> rest_score=contra.findChainTable(yourId).send();
        if(Integer.valueOf(String.valueOf(rest_score.getValue2()))< Integer.valueOf(scoreNumber)){
            return new Result(2);
        }
        if(userMapper.getPassword(friendId)==null){
            return new Result(4);
        }
        contra.makeTransaction(yourId,friendId,yourId+"向"+friendId+"积分转赠",BigInteger.valueOf(Long.parseLong(scoreNumber))).send();
        Trans trans1=new Trans(Utils.geneId(),yourId,LocalDateTime.now().format(formatter).toString(),
                "积分转赠给好友"+friendId,"-"+scoreNumber);
        Trans trans2=new Trans(Utils.geneId()+1,friendId,LocalDateTime.now().format(formatter).toString(),
                "积分转赠来自好友"+yourId,"+"+scoreNumber);
        transMapper.createTrans(trans1);
        transMapper.createTrans(trans2);
        return new Result(3);
    }

    //用户积分购买
    @RequestMapping(value = "/scorebuy", method = RequestMethod.POST)
    public Result scorebuy(@RequestBody Map<String, String> info) throws Exception {
        String id = info.get("id");
        String password = info.get("password");
        String scoreNumber = info.get("score_number");
        String itemName = info.get("itemname");
        String enterpriseId=info.get("brandid");
        if (!loginP(id, password)) {
            return new Result(1);
        }
        Tuple2<byte[], BigInteger> rest_score=contra.findChainTable(id).send();
        if(Integer.valueOf(String.valueOf(rest_score.getValue2()))< Integer.valueOf(scoreNumber)){
            return new Result(2);
        }
        contra.makeTransaction(id,enterpriseId,id+"积分购买" + itemName,BigInteger.valueOf(Long.parseLong(scoreNumber))).send();
        Trans trans = new Trans(Utils.geneId(), id, LocalDateTime.now().format(formatter).toString(), "积分购买" + itemName, "-" + scoreNumber);
        transMapper.createTrans(trans);
        return new Result(3);
    }

    //用户现金购买
    @RequestMapping(value = "moneybuy", method = RequestMethod.POST)
    public Result moneybuy(@RequestBody Map<String, String> info) throws Exception {
        String id = info.get("id");
        String password = info.get("password");
        String scoreNumber = info.get("score_number");
        String itemName = info.get("itemname");
        String enterpriseId=info.get("brandid");
        if (!loginP(id, password)) {
            return new Result(1);
        }
        logger.info(enterpriseId);
        contra.makeTransaction(enterpriseId,id,id+"积分购买" + itemName,BigInteger.valueOf(Long.parseLong(scoreNumber))).send();
        Trans trans = new Trans(Utils.geneId(), id, LocalDateTime.now().format(formatter).toString(), "现金购买" + itemName, "+" + scoreNumber);
        transMapper.createTrans(trans);
        return new Result(3);
    }

    //用户查询历史记录
    @RequestMapping(value = "historyP", method = RequestMethod.GET)
    public Result historyP(@RequestParam("id") String id, @RequestParam("password") String password) throws Exception {
        if (!loginP(id, password)){
            return new Result(1);
        }
        Result res=new Result(3);
        res.setDatalist(transMapper.getTransByName(id));
        return res;
    }
}
