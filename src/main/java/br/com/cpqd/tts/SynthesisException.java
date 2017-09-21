package br.com.cpqd.tts;


public class SynthesisException extends Exception
{

	private static final long serialVersionUID = -8332019635745289022L;

	long code = 0;
	
	long subCode = 0;
	
	long line = 0;
	
	String fileName;
	
	public SynthesisException( int code, int subCode, String message )
	{
		super(message);
		this.code = code;
		this.subCode = subCode;
	}

	public SynthesisException( int code, int subCode, String message, Throwable cause )
	{
		super(message, cause);
		this.code = code;
		this.subCode = subCode;
	}

	public SynthesisException( int errorCode, String message )
	{
		super(message);
		this.code = errorCode;
	}

	public long getCode()
	{
		return code;
	}
	
	public long getSubCode()
	{
		return subCode;
	}
	
}
