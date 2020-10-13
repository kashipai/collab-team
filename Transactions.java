package sampleProgram;
import java.util.*;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.springframework.stereotype.Service;

@Service("Multimaptest")

public class Transactions {
	String custId;
	String transaction;
	
	Multimap<String, String> multimap = ArrayListMultimap.create();
	
	public void setcustId(String custId)
	{
		this.custId = custId;
	}
	
	public String getcustId()
	{
		return this.custId;
	}
	
	public void settransaction(String transaction)
	{
		this.transaction = transaction;
	}
	
	public String gettransaction()
	{
		return this.transaction;
	}
	
public void addTransaction(String custId,String transaction)
{
 multimap.put(custId, transaction);
}
public Collection getValues(String custId)
{
	return multimap.get(custId);
}


}