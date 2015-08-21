/*
 * Created on 2005-11-22
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.job5156.util;

/**
 * @author xurun
 * 加解密
 */
public class SecurityManager{

    private String privateKey="";
    private int privateKeyLength=10;

    public SecurityManager(){
       // createPrivateKey();        
    }
    
    public void createPrivateKey() {
        RandomString randomString = new RandomString();
        randomString.setLength(privateKeyLength);
        randomString.setCharset("a-zA-Z0-9");
        try {
            randomString.generateRandomObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        privateKey = randomString.getRandom();
    }

    /**
     * 对某个串的加密
     */
    public String getEncryptCode(String beforeStr) {
        if("".equalsIgnoreCase(privateKey)){
            createPrivateKey();
        }
        privateKeyActiveLength();
        return encryptString(beforeStr);
    }

    /**
     * 对某个串的解密
     */
    public String getDecryptCode(String afterStr) {
        if("".equalsIgnoreCase(privateKey)){
            createPrivateKey();
        }
        privateKeyActiveLength();
        return decryptString(afterStr);
    }

    /**加密作业**/
    private String encryptString(String beforeStr){
        String afterStr="";
        int keyPosition = 0;
        for(int i=0;i<beforeStr.length();i++){
            keyPosition = keyPosition+i;
            char beforChar = beforeStr.charAt(i);
            if(keyPosition>=privateKeyLength){ //如果密钥已经到最后，再从头开始
                keyPosition = keyPosition % privateKeyLength;
            }

            char keyChar = privateKey.charAt(keyPosition);
            
            afterStr += String.valueOf(keyChar + beforChar)+  ":";
        }
        return afterStr;
    }
    

    private void privateKeyActiveLength(){
        privateKeyLength= privateKey.length();
    }
    
    /**解密作业**/
    private String decryptString(String afterStr){
        String beforeStr="";
        int keyPosition = 0;
        
        String[] divStr = afterStr.split(":");
            for(int i=0;i<divStr.length;i++){
                if(!Validator.isNumber(divStr[i])){return afterStr;/**密文只能是数字，否则退出放弃解密*/}
                keyPosition = keyPosition+i;            
                int afterChar = Integer.parseInt(divStr[i]);
                if(keyPosition>=privateKeyLength){ //如果密钥已经到最后，再从头开始
                    keyPosition = keyPosition % privateKeyLength;
                  
                }
                char keyChar = privateKey.charAt(keyPosition);
                
                beforeStr += (char)(afterChar - keyChar);
            }        
            return beforeStr;
    }

    /**
     * 设置密钥，如果没有设置，则由系统自动生成。
     */
    public void setPrivateKey(String key) {
        this.privateKey = key;
    }

    /**设置密钥的长度*/
    public void setPrivateKeyLength(int length) {
          this.privateKeyLength = length;
    }
    
    public static void main(String args[]){
       String waitcode = "1243中国v 259wjergtw4ytm";
//     String waitcode = "4444444";
        
        SecurityManager kc = new SecurityManager();
        
       // kc.setPrivateKeyLength(20);
        kc.setPrivateKey("SDFDSAFSDF");
        
        
        String aftercode = kc.getEncryptCode(waitcode);

        String beforecode = kc.getDecryptCode(aftercode);
        
        System.out.println("\n待加密串="+waitcode);
        System.out.println("密       钥="+kc.getPrivateKey());
        System.out.println("加密后的串="+aftercode);
        System.out.println("解密结果="+beforecode);
        
        if(waitcode.equalsIgnoreCase(beforecode)){
            System.out.println("加解密成功 !");
        }
    }
    
    /**
     * @return Returns the privateKey.
     */
    public String getPrivateKey() {
        return privateKey;
    }
}
