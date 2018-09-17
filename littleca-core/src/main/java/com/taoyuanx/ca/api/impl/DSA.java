package com.taoyuanx.ca.api.impl;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;

import com.taoyuanx.ca.api.AsymmetricalSignature;
import com.taoyuanx.ca.api.AsymmetricalUtil;

/**
 * dsa 实现
 * @author 都市桃源
 * 2018年7月1日下午10:36:40
 * TODO
 */
public class DSA  implements AsymmetricalSignature{
	@Override
	public byte[] sign(byte[] data, PrivateKey privateKey, String signAlgorithm) throws Exception {
		Signature signature = AsymmetricalUtil.getSignatureInstance(signAlgorithm);
		signature.initSign(privateKey);
		signature.update(data);
		return signature.sign();
	}

	@Override
	public boolean verifySign(byte[] signData, byte[] content, PublicKey publicKey, String signAlgorithm) throws Exception {
		Signature signature = AsymmetricalUtil.getSignatureInstance(signAlgorithm);
		signature.initVerify(publicKey);
		signature.update(content);
		return signature.verify(signData);
	}



}
