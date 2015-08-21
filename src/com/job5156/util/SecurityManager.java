/*
 * Created on 2005-11-22
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.job5156.util;

/**
 * @author xurun
 * �ӽ���
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
     * ��ĳ�����ļ���
     */
    public String getEncryptCode(String beforeStr) {
        if("".equalsIgnoreCase(privateKey)){
            createPrivateKey();
        }
        privateKeyActiveLength();
        return encryptString(beforeStr);
    }

    /**
     * ��ĳ�����Ľ���
     */
    public String getDecryptCode(String afterStr) {
        if("".equalsIgnoreCase(privateKey)){
            createPrivateKey();
        }
        privateKeyActiveLength();
        return decryptString(afterStr);
    }

    /**������ҵ**/
    private String encryptString(String beforeStr){
        String afterStr="";
        int keyPosition = 0;
        for(int i=0;i<beforeStr.length();i++){
            keyPosition = keyPosition+i;
            char beforChar = beforeStr.charAt(i);
            if(keyPosition>=privateKeyLength){ //�����Կ�Ѿ�������ٴ�ͷ��ʼ
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
    
    /**������ҵ**/
    private String decryptString(String afterStr){
        String beforeStr="";
        int keyPosition = 0;
        
        String[] divStr = afterStr.split(":");
            for(int i=0;i<divStr.length;i++){
                if(!Validator.isNumber(divStr[i])){return afterStr;/**����ֻ�������֣������˳���������*/}
                keyPosition = keyPosition+i;            
                int afterChar = Integer.parseInt(divStr[i]);
                if(keyPosition>=privateKeyLength){ //�����Կ�Ѿ�������ٴ�ͷ��ʼ
                    keyPosition = keyPosition % privateKeyLength;
                  
                }
                char keyChar = privateKey.charAt(keyPosition);
                
                beforeStr += (char)(afterChar - keyChar);
            }        
            return beforeStr;
    }

    /**
     * ������Կ�����û�����ã�����ϵͳ�Զ����ɡ�
     */
    public void setPrivateKey(String key) {
        this.privateKey = key;
    }

    /**������Կ�ĳ���*/
    public void setPrivateKeyLength(int length) {
          this.privateKeyLength = length;
    }
    
    public static void main(String args[]){
       String waitcode = "1243�й�v 259wjergtw4ytm";
//     String waitcode = "4444444";
        
        SecurityManager kc = new SecurityManager();
        
       // kc.setPrivateKeyLength(20);
        kc.setPrivateKey("SDFDSAFSDF");
        
        
        String aftercode = kc.getEncryptCode(waitcode);

        String beforecode = kc.getDecryptCode(aftercode);
        
        System.out.println("\n�����ܴ�="+waitcode);
        System.out.println("��       Կ="+kc.getPrivateKey());
        System.out.println("���ܺ�Ĵ�="+aftercode);
        System.out.println("���ܽ��="+beforecode);
        
        if(waitcode.equalsIgnoreCase(beforecode)){
            System.out.println("�ӽ��ܳɹ� !");
        }
    }
    
    /**
     * @return Returns the privateKey.
     */
    public String getPrivateKey() {
        return privateKey;
    }
}
