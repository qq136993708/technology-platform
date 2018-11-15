package com.pcitc.web.utils;

import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.codec.binary.Base64;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class DES3Utils {
	// 秘钥（身份验证）
	private byte[] key;// 1qaz2wsx3edc4rfv5tgb6yhn 长度24
	private byte[] keyiv;// 长度为8
	// 秘钥（web组件）
	private byte[] key0;// 1qaz2wsx3edc4rfv5tgb6yhn 长度24
	private byte[] keyiv0;// 长度为8

	public DES3Utils(String keys) {
		try {
			System.out.println("1DES3Utils=============="+keys);
			key = keys.getBytes("UTF-8");
			keyiv = "123qweas".getBytes("UTF-8");
			key0 = "0okm9ijn8uhb7ygv6tfc5rdx".getBytes("UTF-8");
			keyiv0 = "sin0opec".getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			System.out.println("2DES3Utils=============="+e.getStackTrace()[0].toString());
			e.printStackTrace();
		}
	}

	public String des3Decode(String str) {
		String deString = null;
		byte[] test1 = Base64.decodeBase64(str);
		try {
			// CBC 解密
			byte[] str1 = des3DecodeCBC(test1);
			deString = new String(str1, "UTF-8");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return deString;
	}

	public String des3Decode0(String str) {
		String deString = null;
		byte[] test1 = Base64.decodeBase64(str);
		try {
			// CBC 解密
			byte[] str1 = des3DecodeCBC0(test1);
			deString = new String(str1, "UTF-8");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return deString;
	}

	/**
	 * CBC 加密
	 * 
	 * @param key
	 *            秘钥
	 * @param keyiv
	 *            IV
	 * @param data
	 *            加密明文
	 * @return
	 * @throws Exception
	 */
	public byte[] des3EncodeCBC(byte[] data) throws Exception {
		Key deskey = null;
		DESedeKeySpec spec = new DESedeKeySpec(key);
		SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("DESede");
		deskey = keyfactory.generateSecret(spec);
		Cipher cipher = Cipher.getInstance("DESede" + "/CBC/PKCS5Padding");
		IvParameterSpec ips = new IvParameterSpec(keyiv);
		cipher.init(Cipher.ENCRYPT_MODE, deskey, ips);
		byte[] bOut = cipher.doFinal(data);
		return bOut;
	}

	/**
	 * CBC 解密(身份验证)
	 * 
	 * @param key
	 *            秘钥
	 * @param keyiv
	 *            IV
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public byte[] des3DecodeCBC(byte[] data) throws Exception {
		Key deskey = null;
		DESedeKeySpec spec = new DESedeKeySpec(key);
		SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("DESede");
		deskey = keyfactory.generateSecret(spec);
		Cipher cipher = Cipher.getInstance("DESede" + "/CBC/PKCS5Padding");
		IvParameterSpec ips = new IvParameterSpec(keyiv);
		cipher.init(Cipher.DECRYPT_MODE, deskey, ips);
		byte[] bOut = cipher.doFinal(data);
		return bOut;

	}

	/**
	 * CBC 解密（web组件）
	 * 
	 * @param key1
	 *            秘钥
	 * @param keyiv1
	 *            IV
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public byte[] des3DecodeCBC0(byte[] data) throws Exception {
		Key deskey = null;
		DESedeKeySpec spec = new DESedeKeySpec(key0);
		SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("DESede");
		deskey = keyfactory.generateSecret(spec);
		Cipher cipher = Cipher.getInstance("DESede" + "/CBC/PKCS5Padding");
		IvParameterSpec ips = new IvParameterSpec(keyiv0);
		cipher.init(Cipher.DECRYPT_MODE, deskey, ips);
		byte[] bOut = cipher.doFinal(data);
		return bOut;

	}

	private String getAcountxml(String keyxml) {
		int beginIndex = keyxml.indexOf("<AttributeStatement>");
		int endIndex = keyxml.indexOf("</AttributeStatement>");
		keyxml = keyxml.substring(beginIndex, endIndex);
		keyxml = keyxml + "</AttributeStatement>";
		return keyxml;
	}

	private String[] getUserAndPsdfromToken0(String key) {
		String[] initenstr = new String[2];
		String[] str1 = key.split(",");
		if (str1.length < 1) {
			return null;
		}
		String[] str2 = str1[0].split(":");
		String[] str3 = str1[1].split(":");
		if (str2.length > 1 && str3.length > 1) {
			initenstr[0] = str2[1];
			initenstr[1] = str3[1];
		}
		return initenstr;
	}

	private Map<String, String> parseUsernameAndPsd(String keyxml) {
		Map<String, String> keymap = new HashMap<String, String>();
		String username = "";
		String password = "";
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document document = db.parse(new InputSource(new StringReader(keyxml)));
			NodeList employees = document.getElementsByTagName("Attribute");
			for (int i = 0; i < employees.getLength(); i++) {
				Node node = employees.item(i);
				NamedNodeMap NodeMap = node.getAttributes();
				String value = NodeMap.getNamedItem("Name").getNodeValue();
				System.out.println(value);
				if ("UserId".equals(value)) {
					username = node.getTextContent().trim();
				} else if ("Password".equals(value)) {
					password = node.getTextContent().trim();
				}
			}
			System.out.println("ceshi user: " + username + " password:" + password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		keymap.put("username", username);
		keymap.put("password", password);
		return keymap;
	}

	public Map<String, String> getAcountByToken(String key) {
		String keyxml = getAcountxml(key);
		return parseUsernameAndPsd(keyxml);
	}

	public Map<String, String> getAcountByToken0(String key) {
		Map<String, String> keymap = new HashMap<String, String>();
		String[] initenstr = getUserAndPsdfromToken0(key);
		String username = initenstr[0];
		String password = initenstr[1];
		keymap.put("username", username);
		keymap.put("password", password);
		return keymap;
	}
}
