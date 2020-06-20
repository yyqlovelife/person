package com.scut.blockchain.Contracts;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

import org.fisco.bcos.channel.client.TransactionSucCallback;
import org.fisco.bcos.channel.event.filter.EventLogPushWithDecodeCallback;
import org.fisco.bcos.web3j.abi.EventEncoder;
import org.fisco.bcos.web3j.abi.FunctionReturnDecoder;
import org.fisco.bcos.web3j.abi.TypeReference;
import org.fisco.bcos.web3j.abi.datatypes.DynamicArray;
import org.fisco.bcos.web3j.abi.datatypes.Event;
import org.fisco.bcos.web3j.abi.datatypes.Function;
import org.fisco.bcos.web3j.abi.datatypes.Type;
import org.fisco.bcos.web3j.abi.datatypes.Utf8String;
import org.fisco.bcos.web3j.abi.datatypes.generated.Int256;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.RemoteCall;
import org.fisco.bcos.web3j.protocol.core.methods.response.Log;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.fisco.bcos.web3j.tuples.generated.Tuple1;
import org.fisco.bcos.web3j.tuples.generated.Tuple2;
import org.fisco.bcos.web3j.tuples.generated.Tuple3;
import org.fisco.bcos.web3j.tx.Contract;
import org.fisco.bcos.web3j.tx.TransactionManager;
import org.fisco.bcos.web3j.tx.gas.ContractGasProvider;
import org.fisco.bcos.web3j.tx.txdecode.TransactionDecoder;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.fisco.bcos.web3j.codegen.SolidityFunctionWrapperGenerator in the
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version none.
 */
@SuppressWarnings("unchecked")
public class TableTest extends Contract {
    public static final String[] BINARY_ARRAY = {"60806040523480156200001157600080fd5b506110016000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166356004b6a6040805190810160405280600681526020017f745f7465737400000000000000000000000000000000000000000000000000008152506040518263ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004016200010191906200024a565b602060405180830381600087803b1580156200011c57600080fd5b505af115801562000131573d6000803e3d6000fd5b505050506040513d601f19601f8201168201806040525062000157919081019062000174565b50620002f4565b60006200016c8251620002a3565b905092915050565b6000602082840312156200018757600080fd5b600062000197848285016200015e565b91505092915050565b6000620001ad8262000298565b808452620001c3816020860160208601620002ad565b620001ce81620002e3565b602085010191505092915050565b6000600482527f6e616d65000000000000000000000000000000000000000000000000000000006020830152604082019050919050565b6000601182527f6974656d5f69642c6974656d5f6e616d650000000000000000000000000000006020830152604082019050919050565b60006060820190508181036000830152620002668184620001a0565b905081810360208301526200027b81620001dc565b90508181036040830152620002908162000213565b905092915050565b600081519050919050565b6000819050919050565b60005b83811015620002cd578082015181840152602081019050620002b0565b83811115620002dd576000848401525b50505050565b6000601f19601f8301169050919050565b611fc980620003046000396000f300608060405260043610610062576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff168063487a5a1014610067578063c4f41ab3146100a4578063ebf3b24f146100e1578063fcd7e3c11461011e575b600080fd5b34801561007357600080fd5b5061008e6004803603610089919081019061193e565b61015d565b60405161009b9190611c10565b60405180910390f35b3480156100b057600080fd5b506100cb60048036036100c691908101906118ea565b610627565b6040516100d89190611c10565b60405180910390f35b3480156100ed57600080fd5b506101086004803603610103919081019061193e565b6109c6565b6040516101159190611c10565b60405180910390f35b34801561012a57600080fd5b5061014560048036036101409190810190611868565b610ded565b60405161015493929190611bc4565b60405180910390f35b60008060008060008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663f23f63c96040805190810160405280600681526020017f745f7465737400000000000000000000000000000000000000000000000000008152506040518263ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004016102109190611c2b565b602060405180830381600087803b15801561022a57600080fd5b505af115801561023e573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052506102629190810190611816565b93508373ffffffffffffffffffffffffffffffffffffffff166313db93466040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b1580156102c857600080fd5b505af11580156102dc573d6000803e3d6000fd5b505050506040513d601f19601f8201168201806040525061030091908101906117ed565b92508273ffffffffffffffffffffffffffffffffffffffff1663e942b516876040518263ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004016103579190611d60565b600060405180830381600087803b15801561037157600080fd5b505af1158015610385573d6000803e3d6000fd5b505050508373ffffffffffffffffffffffffffffffffffffffff16637857d7c96040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b1580156103ed57600080fd5b505af1158015610401573d6000803e3d6000fd5b505050506040513d601f19601f82011682018060405250610425919081019061179b565b91508173ffffffffffffffffffffffffffffffffffffffff1663cd30a1d1896040518263ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040161047c9190611d0b565b600060405180830381600087803b15801561049657600080fd5b505af11580156104aa573d6000803e3d6000fd5b505050508173ffffffffffffffffffffffffffffffffffffffff1663e44594b9886040518263ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004016105039190611db5565b600060405180830381600087803b15801561051d57600080fd5b505af1158015610531573d6000803e3d6000fd5b505050508373ffffffffffffffffffffffffffffffffffffffff1663bf2b70a18985856040518463ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040161058e93929190611cad565b602060405180830381600087803b1580156105a857600080fd5b505af11580156105bc573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052506105e0919081019061183f565b90507f8e5890af40fc24a059396aca2f83d6ce41fcef086876548fa4fb8ec27e9d292a816040516106119190611c10565b60405180910390a1809450505050509392505050565b6000806000806000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663f23f63c96040805190810160405280600681526020017f745f7465737400000000000000000000000000000000000000000000000000008152506040518263ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004016106d89190611c2b565b602060405180830381600087803b1580156106f257600080fd5b505af1158015610706573d6000803e3d6000fd5b505050506040513d601f19601f8201168201806040525061072a9190810190611816565b92508273ffffffffffffffffffffffffffffffffffffffff16637857d7c96040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b15801561079057600080fd5b505af11580156107a4573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052506107c8919081019061179b565b91508173ffffffffffffffffffffffffffffffffffffffff1663cd30a1d1876040518263ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040161081f9190611d0b565b600060405180830381600087803b15801561083957600080fd5b505af115801561084d573d6000803e3d6000fd5b505050508173ffffffffffffffffffffffffffffffffffffffff1663e44594b9866040518263ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004016108a69190611db5565b600060405180830381600087803b1580156108c057600080fd5b505af11580156108d4573d6000803e3d6000fd5b505050508273ffffffffffffffffffffffffffffffffffffffff166328bb211787846040518363ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040161092f929190611c4d565b602060405180830381600087803b15801561094957600080fd5b505af115801561095d573d6000803e3d6000fd5b505050506040513d601f19601f82011682018060405250610981919081019061183f565b90507f4b930e280fe29620bdff00c88155d46d6d82a39f45dd5c3ea114dc3157358112816040516109b29190611c10565b60405180910390a180935050505092915050565b6000806000806000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663f23f63c96040805190810160405280600681526020017f745f7465737400000000000000000000000000000000000000000000000000008152506040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401610a779190611c2b565b602060405180830381600087803b158015610a9157600080fd5b505af1158015610aa5573d6000803e3d6000fd5b505050506040513d601f19601f82011682018060405250610ac99190810190611816565b92508273ffffffffffffffffffffffffffffffffffffffff166313db93466040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b158015610b2f57600080fd5b505af1158015610b43573d6000803e3d6000fd5b505050506040513d601f19601f82011682018060405250610b6791908101906117ed565b91508173ffffffffffffffffffffffffffffffffffffffff1663e942b516886040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401610bbe9190611d0b565b600060405180830381600087803b158015610bd857600080fd5b505af1158015610bec573d6000803e3d6000fd5b505050508173ffffffffffffffffffffffffffffffffffffffff16632ef8ba74876040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401610c459190611db5565b600060405180830381600087803b158015610c5f57600080fd5b505af1158015610c73573d6000803e3d6000fd5b505050508173ffffffffffffffffffffffffffffffffffffffff1663e942b516866040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401610ccc9190611d60565b600060405180830381600087803b158015610ce657600080fd5b505af1158015610cfa573d6000803e3d6000fd5b50", "5050508273ffffffffffffffffffffffffffffffffffffffff166331afac3688846040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401610d55929190611c7d565b602060405180830381600087803b158015610d6f57600080fd5b505af1158015610d83573d6000803e3d6000fd5b505050506040513d601f19601f82011682018060405250610da7919081019061183f565b90507fc57b01fa77f41df77eaab79a0e2623fab2e7ae3e9530d9b1cab225ad65f2b7ce81604051610dd89190611c10565b60405180910390a18093505050509392505050565b6060806060600080600060608060606000806000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663f23f63c96040805190810160405280600681526020017f745f7465737400000000000000000000000000000000000000000000000000008152506040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401610eaa9190611c2b565b602060405180830381600087803b158015610ec457600080fd5b505af1158015610ed8573d6000803e3d6000fd5b505050506040513d601f19601f82011682018060405250610efc9190810190611816565b97508773ffffffffffffffffffffffffffffffffffffffff16637857d7c96040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b158015610f6257600080fd5b505af1158015610f76573d6000803e3d6000fd5b505050506040513d601f19601f82011682018060405250610f9a919081019061179b565b96508773ffffffffffffffffffffffffffffffffffffffff1663e8434e398d896040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401610ff3929190611c4d565b602060405180830381600087803b15801561100d57600080fd5b505af1158015611021573d6000803e3d6000fd5b505050506040513d601f19601f8201168201806040525061104591908101906117c4565b95508573ffffffffffffffffffffffffffffffffffffffff1663949d225d6040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b1580156110ab57600080fd5b505af11580156110bf573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052506110e3919081019061183f565b60405190808252806020026020018201604052801561111657816020015b60608152602001906001900390816111015790505b5094508573ffffffffffffffffffffffffffffffffffffffff1663949d225d6040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b15801561117d57600080fd5b505af1158015611191573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052506111b5919081019061183f565b6040519080825280602002602001820160405280156111e35781602001602082028038833980820191505090505b5093508573ffffffffffffffffffffffffffffffffffffffff1663949d225d6040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b15801561124a57600080fd5b505af115801561125e573d6000803e3d6000fd5b505050506040513d601f19601f82011682018060405250611282919081019061183f565b6040519080825280602002602001820160405280156112b557816020015b60608152602001906001900390816112a05790505b509250600091505b8573ffffffffffffffffffffffffffffffffffffffff1663949d225d6040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b15801561132157600080fd5b505af1158015611335573d6000803e3d6000fd5b505050506040513d601f19601f82011682018060405250611359919081019061183f565b82121561165f578573ffffffffffffffffffffffffffffffffffffffff1663846719e0836040518263ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004016113b59190611c10565b602060405180830381600087803b1580156113cf57600080fd5b505af11580156113e3573d6000803e3d6000fd5b505050506040513d601f19601f8201168201806040525061140791908101906117ed565b90508073ffffffffffffffffffffffffffffffffffffffff16639c981fcb6040518163ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040161145c90611ceb565b600060405180830381600087803b15801561147657600080fd5b505af115801561148a573d6000803e3d6000fd5b505050506040513d6000823e3d601f19601f820116820180604052506114b391908101906118a9565b85838151811015156114c157fe5b906020019060200201819052508073ffffffffffffffffffffffffffffffffffffffff1663fda69fae6040518163ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040161152190611d95565b602060405180830381600087803b15801561153b57600080fd5b505af115801561154f573d6000803e3d6000fd5b505050506040513d601f19601f82011682018060405250611573919081019061183f565b848381518110151561158157fe5b90602001906020020181815250508073ffffffffffffffffffffffffffffffffffffffff16639c981fcb6040518163ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004016115e290611d40565b600060405180830381600087803b1580156115fc57600080fd5b505af1158015611610573d6000803e3d6000fd5b505050506040513d6000823e3d601f19601f8201168201806040525061163991908101906118a9565b838381518110151561164757fe5b906020019060200201819052508160010191506112bd565b8484849a509a509a5050505050505050509193909250565b60006116838251611ec6565b905092915050565b60006116978251611ed8565b905092915050565b60006116ab8251611eea565b905092915050565b60006116bf8251611efc565b905092915050565b60006116d38235611f0e565b905092915050565b60006116e78251611f0e565b905092915050565b600082601f830112151561170257600080fd5b813561171561171082611e10565b611de3565b9150808252602083016020830185838301111561173157600080fd5b61173c838284611f3c565b50505092915050565b600082601f830112151561175857600080fd5b815161176b61176682611e10565b611de3565b9150808252602083016020830185838301111561178757600080fd5b611792838284611f4b565b50505092915050565b6000602082840312156117ad57600080fd5b60006117bb84828501611677565b91505092915050565b6000602082840312156117d657600080fd5b60006117e48482850161168b565b91505092915050565b6000602082840312156117ff57600080fd5b600061180d8482850161169f565b91505092915050565b60006020828403121561182857600080fd5b6000611836848285016116b3565b91505092915050565b60006020828403121561185157600080fd5b600061185f848285016116db565b91505092915050565b60006020828403121561187a57600080fd5b600082013567ffffffffffffffff81111561189457600080fd5b6118a0848285016116ef565b91505092915050565b6000602082840312156118bb57600080fd5b600082015167ffffffffffffffff8111156118d557600080fd5b6118e184828501611745565b91505092915050565b600080604083850312156118fd57600080fd5b600083013567ffffffffffffffff81111561191757600080fd5b611923858286016116ef565b9250506020611934858286016116c7565b9150509250929050565b60008060006060848603121561195357600080fd5b600084013567ffffffffffffffff81111561196d57600080fd5b611979868287016116ef565b935050602061198a868287016116c7565b925050604084013567ffffffffffffffff8111156119a757600080fd5b6119b3868287016116ef565b9150509250925092565b60006119c882611e56565b8084526020840193506119da83611e3c565b60005b82811015611a0c576119f0868351611aa4565b6119f982611e82565b91506020860195506001810190506119dd565b50849250505092915050565b6000611a2382611e61565b80845260208401935083602082028501611a3c85611e49565b60005b84811015611a75578383038852611a57838351611ae9565b9250611a6282611e8f565b9150602088019750600181019050611a3f565b508196508694505050505092915050565b611a8f81611f18565b82525050565b611a9e81611f2a565b82525050565b611aad81611ebc565b82525050565b6000611abe82611e77565b808452611ad2816020860160208601611f4b565b611adb81611f7e565b602085010191505092915050565b6000611af482611e6c565b808452611b08816020860160208601611f4b565b611b1181611f7e565b602085010191505092915050565b6000600482527f6e616d65000000000000000000000000000000000000000000000000000000006020830152604082019050919050565b6000600982527f6974656d5f6e616d6500000000000000000000000000000000000000000000006020830152604082019050919050565b6000600782527f6974656d5f6964000000000000000000000000000000000000000000000000006020830152604082019050919050565b60006060820190508181036000830152611bde8186611a18565b90508181036020830152611bf281856119bd565b90508181036040830152611c068184611a18565b9050949350505050565b6000602082019050611c256000830184611aa4565b92915050565b60006020820190508181036000830152611c458184611ae9565b905092915050565b60006040820190508181036000830152611c678185611ab3565b9050611c766020830184611a86565b9392505050565b60006040820190508181036000830152611c978185611ab3565b9050611ca66020830184611a95565b9392505050565b60006060820190508181036000830152611cc78186611ab3565b9050611cd66020830185611a95565b611ce36040830184611a86565b949350505050565b60006020820190508181036000830152", "611d0481611b1f565b9050919050565b60006040820190508181036000830152611d2481611b1f565b90508181036020830152611d388184611ab3565b905092915050565b60006020820190508181036000830152611d5981611b56565b9050919050565b60006040820190508181036000830152611d7981611b56565b90508181036020830152611d8d8184611ab3565b905092915050565b60006020820190508181036000830152611dae81611b8d565b9050919050565b60006040820190508181036000830152611dce81611b8d565b9050611ddd6020830184611aa4565b92915050565b6000604051905081810181811067ffffffffffffffff82111715611e0657600080fd5b8060405250919050565b600067ffffffffffffffff821115611e2757600080fd5b601f19601f8301169050602081019050919050565b6000602082019050919050565b6000602082019050919050565b600081519050919050565b600081519050919050565b600081519050919050565b600081519050919050565b6000602082019050919050565b6000602082019050919050565b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b6000819050919050565b6000611ed182611e9c565b9050919050565b6000611ee382611e9c565b9050919050565b6000611ef582611e9c565b9050919050565b6000611f0782611e9c565b9050919050565b6000819050919050565b6000611f2382611e9c565b9050919050565b6000611f3582611e9c565b9050919050565b82818337600083830152505050565b60005b83811015611f69578082015181840152602081019050611f4e565b83811115611f78576000848401525b50505050565b6000601f19601f83011690509190505600a265627a7a72305820fd04a386f5e6d485cf863ffa0ecf9766a18f8061d21e61c94bab6b7488fd61eb6c6578706572696d656e74616cf50037"};

    public static final String BINARY = String.join("", BINARY_ARRAY);

    public static final String[] ABI_ARRAY = {"[{\"constant\":false,\"inputs\":[{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"item_id\",\"type\":\"int256\"},{\"name\":\"item_name\",\"type\":\"string\"}],\"name\":\"update\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"item_id\",\"type\":\"int256\"}],\"name\":\"remove\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"item_id\",\"type\":\"int256\"},{\"name\":\"item_name\",\"type\":\"string\"}],\"name\":\"insert\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"name\",\"type\":\"string\"}],\"name\":\"select\",\"outputs\":[{\"name\":\"\",\"type\":\"string[]\"},{\"name\":\"\",\"type\":\"int256[]\"},{\"name\":\"\",\"type\":\"string[]\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"inputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"constructor\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"count\",\"type\":\"int256\"}],\"name\":\"CreateResult\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"count\",\"type\":\"int256\"}],\"name\":\"InsertResult\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"count\",\"type\":\"int256\"}],\"name\":\"UpdateResult\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"count\",\"type\":\"int256\"}],\"name\":\"RemoveResult\",\"type\":\"event\"}]"};

    public static final String ABI = String.join("", ABI_ARRAY);

    public static final TransactionDecoder transactionDecoder = new TransactionDecoder(ABI, BINARY);

    public static final String FUNC_UPDATE = "update";

    public static final String FUNC_REMOVE = "remove";

    public static final String FUNC_INSERT = "insert";

    public static final String FUNC_SELECT = "select";

    public static final Event CREATERESULT_EVENT = new Event("CreateResult",
            Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {
            }));
    ;

    public static final Event INSERTRESULT_EVENT = new Event("InsertResult",
            Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {
            }));
    ;

    public static final Event UPDATERESULT_EVENT = new Event("UpdateResult",
            Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {
            }));
    ;

    public static final Event REMOVERESULT_EVENT = new Event("RemoveResult",
            Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {
            }));
    ;

    @Deprecated
    protected TableTest(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected TableTest(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected TableTest(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected TableTest(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static TransactionDecoder getTransactionDecoder() {
        return transactionDecoder;
    }

    public RemoteCall<TransactionReceipt> update(String name, BigInteger item_id, String item_name) {
        final Function function = new Function(
                FUNC_UPDATE,
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(name),
                        new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(item_id),
                        new org.fisco.bcos.web3j.abi.datatypes.Utf8String(item_name)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void update(String name, BigInteger item_id, String item_name, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_UPDATE,
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(name),
                        new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(item_id),
                        new org.fisco.bcos.web3j.abi.datatypes.Utf8String(item_name)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String updateSeq(String name, BigInteger item_id, String item_name) {
        final Function function = new Function(
                FUNC_UPDATE,
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(name),
                        new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(item_id),
                        new org.fisco.bcos.web3j.abi.datatypes.Utf8String(item_name)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple3<String, BigInteger, String> getUpdateInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_UPDATE,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {
                }, new TypeReference<Int256>() {
                }, new TypeReference<Utf8String>() {
                }));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());
        ;
        return new Tuple3<String, BigInteger, String>(

                (String) results.get(0).getValue(),
                (BigInteger) results.get(1).getValue(),
                (String) results.get(2).getValue()
        );
    }

    public Tuple1<BigInteger> getUpdateOutput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getOutput();
        final Function function = new Function(FUNC_UPDATE,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {
                }));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());
        ;
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
        );
    }

    public RemoteCall<TransactionReceipt> remove(String name, BigInteger item_id) {
        final Function function = new Function(
                FUNC_REMOVE,
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(name),
                        new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(item_id)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void remove(String name, BigInteger item_id, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_REMOVE,
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(name),
                        new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(item_id)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String removeSeq(String name, BigInteger item_id) {
        final Function function = new Function(
                FUNC_REMOVE,
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(name),
                        new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(item_id)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple2<String, BigInteger> getRemoveInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_REMOVE,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {
                }, new TypeReference<Int256>() {
                }));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());
        ;
        return new Tuple2<String, BigInteger>(

                (String) results.get(0).getValue(),
                (BigInteger) results.get(1).getValue()
        );
    }

    public Tuple1<BigInteger> getRemoveOutput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getOutput();
        final Function function = new Function(FUNC_REMOVE,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {
                }));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());
        ;
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
        );
    }

    public RemoteCall<TransactionReceipt> insert(String name, BigInteger item_id, String item_name) {
        final Function function = new Function(
                FUNC_INSERT,
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(name),
                        new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(item_id),
                        new org.fisco.bcos.web3j.abi.datatypes.Utf8String(item_name)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void insert(String name, BigInteger item_id, String item_name, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_INSERT,
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(name),
                        new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(item_id),
                        new org.fisco.bcos.web3j.abi.datatypes.Utf8String(item_name)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String insertSeq(String name, BigInteger item_id, String item_name) {
        final Function function = new Function(
                FUNC_INSERT,
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(name),
                        new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(item_id),
                        new org.fisco.bcos.web3j.abi.datatypes.Utf8String(item_name)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple3<String, BigInteger, String> getInsertInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_INSERT,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {
                }, new TypeReference<Int256>() {
                }, new TypeReference<Utf8String>() {
                }));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());
        ;
        return new Tuple3<String, BigInteger, String>(

                (String) results.get(0).getValue(),
                (BigInteger) results.get(1).getValue(),
                (String) results.get(2).getValue()
        );
    }

    public Tuple1<BigInteger> getInsertOutput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getOutput();
        final Function function = new Function(FUNC_INSERT,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {
                }));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());
        ;
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
        );
    }

    public RemoteCall<Tuple3<List<String>, List<BigInteger>, List<String>>> select(String name) {
        final Function function = new Function(FUNC_SELECT,
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(name)),
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Utf8String>>() {
                }, new TypeReference<DynamicArray<Int256>>() {
                }, new TypeReference<DynamicArray<Utf8String>>() {
                }));
        return new RemoteCall<Tuple3<List<String>, List<BigInteger>, List<String>>>(
                new Callable<Tuple3<List<String>, List<BigInteger>, List<String>>>() {
                    @Override
                    public Tuple3<List<String>, List<BigInteger>, List<String>> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<List<String>, List<BigInteger>, List<String>>(
                                convertToNative((List<Utf8String>) results.get(0).getValue()),
                                convertToNative((List<Int256>) results.get(1).getValue()),
                                convertToNative((List<Utf8String>) results.get(2).getValue()));
                    }
                });
    }

    public List<CreateResultEventResponse> getCreateResultEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(CREATERESULT_EVENT, transactionReceipt);
        ArrayList<CreateResultEventResponse> responses = new ArrayList<CreateResultEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            CreateResultEventResponse typedResponse = new CreateResultEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.count = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public void registerCreateResultEventLogFilter(String fromBlock, String toBlock, List<String> otherTopcs, EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(CREATERESULT_EVENT);
        registerEventLogPushFilter(ABI, BINARY, topic0, fromBlock, toBlock, otherTopcs, callback);
    }

    public void registerCreateResultEventLogFilter(EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(CREATERESULT_EVENT);
        registerEventLogPushFilter(ABI, BINARY, topic0, callback);
    }

    public List<InsertResultEventResponse> getInsertResultEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(INSERTRESULT_EVENT, transactionReceipt);
        ArrayList<InsertResultEventResponse> responses = new ArrayList<InsertResultEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            InsertResultEventResponse typedResponse = new InsertResultEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.count = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public void registerInsertResultEventLogFilter(String fromBlock, String toBlock, List<String> otherTopcs, EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(INSERTRESULT_EVENT);
        registerEventLogPushFilter(ABI, BINARY, topic0, fromBlock, toBlock, otherTopcs, callback);
    }

    public void registerInsertResultEventLogFilter(EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(INSERTRESULT_EVENT);
        registerEventLogPushFilter(ABI, BINARY, topic0, callback);
    }

    public List<UpdateResultEventResponse> getUpdateResultEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(UPDATERESULT_EVENT, transactionReceipt);
        ArrayList<UpdateResultEventResponse> responses = new ArrayList<UpdateResultEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            UpdateResultEventResponse typedResponse = new UpdateResultEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.count = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public void registerUpdateResultEventLogFilter(String fromBlock, String toBlock, List<String> otherTopcs, EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(UPDATERESULT_EVENT);
        registerEventLogPushFilter(ABI, BINARY, topic0, fromBlock, toBlock, otherTopcs, callback);
    }

    public void registerUpdateResultEventLogFilter(EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(UPDATERESULT_EVENT);
        registerEventLogPushFilter(ABI, BINARY, topic0, callback);
    }

    public List<RemoveResultEventResponse> getRemoveResultEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(REMOVERESULT_EVENT, transactionReceipt);
        ArrayList<RemoveResultEventResponse> responses = new ArrayList<RemoveResultEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            RemoveResultEventResponse typedResponse = new RemoveResultEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.count = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public void registerRemoveResultEventLogFilter(String fromBlock, String toBlock, List<String> otherTopcs, EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(REMOVERESULT_EVENT);
        registerEventLogPushFilter(ABI, BINARY, topic0, fromBlock, toBlock, otherTopcs, callback);
    }

    public void registerRemoveResultEventLogFilter(EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(REMOVERESULT_EVENT);
        registerEventLogPushFilter(ABI, BINARY, topic0, callback);
    }

    @Deprecated
    public static TableTest load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new TableTest(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static TableTest load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new TableTest(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static TableTest load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new TableTest(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static TableTest load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new TableTest(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<TableTest> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(TableTest.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<TableTest> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(TableTest.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<TableTest> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(TableTest.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<TableTest> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(TableTest.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class CreateResultEventResponse {
        public Log log;

        public BigInteger count;
    }

    public static class InsertResultEventResponse {
        public Log log;

        public BigInteger count;
    }

    public static class UpdateResultEventResponse {
        public Log log;

        public BigInteger count;
    }

    public static class RemoveResultEventResponse {
        public Log log;

        public BigInteger count;
    }
}
