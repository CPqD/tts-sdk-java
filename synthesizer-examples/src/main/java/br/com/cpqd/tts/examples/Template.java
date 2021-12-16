package br.com.cpqd.tts.examples;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import br.com.cpqd.tts.InterpretedListener;
import br.com.cpqd.tts.SynthesisEngine;
import br.com.cpqd.tts.SynthesisException;

public class Template
{

	public static String readFile( String fileName ) throws IOException
	{
		byte[] data = Files.readAllBytes(Paths.get(fileName));
		return new String(data, StandardCharsets.UTF_8);
	}

	public static void main( String[] args ) throws SynthesisException, IOException
	{
		if (args.length != 3)
		{
			System.out.println("Usage: java -jar libcpqdtts-4.x.jar <product path> <template path> <message>");
			return;
		}

		boolean isWindows = System.getProperty("os.name").toLowerCase().indexOf("win") >= 0;

		String libraryPath = args[0] + File.separator + "libcpqdtts.";
		if (isWindows)
			libraryPath += "dll";
		else
			libraryPath += "so";
		
		SynthesisEngine engine = null;

		try {
			
			// initialize the CPqD TTS engine
			engine = new SynthesisEngine(libraryPath, args[0], null);
			
			engine.loadTemplate(args[1]);
			
			MyCallback myCallback = new MyCallback(true, null);
			engine.registerInterpretation( myCallback);
			
			// the third argument is message
			String text;
			File file = new File(args[2]);
			if (file.exists())
				text = readFile(args[2]);
			else
			{
				System.err.println("Nao conseguiu abrir o arquivo: " + args[2]);
				engine.terminate();
				return;
			}
			String ssml = engine.processMessage(text, 0);
			System.out.println(ssml);
			
			engine.validateSSML(ssml);
			System.out.println();
			System.out.println("SSML valido");
			
			engine.unloadTemplate(args[1]);

		} catch (SynthesisException ex)
		{
			System.out.println(ex);
		}

		engine.terminate();
	}
	
	
	public static class MyCallback extends InterpretedListener
	{
		MyCallback(boolean normalize, Object data) {
			super("MinhaCallBack", normalize, data);
		}
		
		
		@Override
		public String callback(String input, Object data) {
			return input + " meu teste";
		}
		
	}

}
