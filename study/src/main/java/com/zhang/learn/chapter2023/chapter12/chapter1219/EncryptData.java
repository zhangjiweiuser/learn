package com.zhang.learn.chapter2023.chapter12.chapter1219;

import lombok.Data;

@Data
public class EncryptData {
    private String name;

    private String age;

    private String data;

    private String sign;

    public String getData() {
//        Map<String, String> map = RsaEncrypUtil.initRSAKey(2048);
//        System.out.println(map);
//        String publicKey = map.get("publicKey");
//        System.out.println("-----publicKey-----");
//        System.out.println(publicKey);
//        String privateKey = map.get("privateKey");
//        System.out.println("-----privateKey-----");
//        System.out.println(privateKey);
        String publickey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmVtzRoe3i7BAD+YUSSSfMUVXzZy+efejgDHg/gEb4fRQ3/LzQY4ZMOjnBlpClTB66t3TOcikE1DiKvjTvw8uLeQ7YrtGY4xZ4EuI0egpJGUldWCCl6Qy/j3Ys6uY0euEgPLDL2H8UWdJK8kjcqTbBDXGjbrXSdy8wbTyzH3O4j2/n+teeQwfAFt1c9De6UDBjdbpj6Dkiym/GuxPTR+mRsEg3/Bic1NDryChLcIJja81mx29o/p3kDoYYJB2Nooes+5fM5bFVfhSt65GjIQQfM45qFu4EsUvBCD1qQnmE20tYtuhWfcrZtGW6c0e9NvrfCE6tnl/+08aL7LOI+7scQIDAQAB";
        String privateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCZW3NGh7eLsEAP5hRJJJ8xRVfNnL5596OAMeD+ARvh9FDf8vNBjhkw6OcGWkKVMHrq3dM5yKQTUOIq+NO/Dy4t5Dtiu0ZjjFngS4jR6CkkZSV1YIKXpDL+Pdizq5jR64SA8sMvYfxRZ0krySNypNsENcaNutdJ3LzBtPLMfc7iPb+f6155DB8AW3Vz0N7pQMGN1umPoOSLKb8a7E9NH6ZGwSDf8GJzU0OvIKEtwgmNrzWbHb2j+neQOhhgkHY2ih6z7l8zlsVV+FK3rkaMhBB8zjmoW7gSxS8EIPWpCeYTbS1i26FZ9ytm0ZbpzR702+t8ITq2eX/7Txovss4j7uxxAgMBAAECggEAPLDEXhU3vkByGdikDo4/sfAPX3+4oewu+HzE3cDyl+loWDh9rGPf9Es3onv1/bTB8FD5VtTgmgRYfUkcA3Cuhdrc5aXXpW3V474A15FZNt4QhPM8u2ZwB83SBMjUIb9jIOTx+b59bHnDq2BedvBm/LOLcGuQ59pDmSVTMTpYtY+9ccQKD3xBwxqGgRlRXk6haGmz0S+hS7tHBZCV69YB1iGpDNJNfuA6OxaXwjyq29dBpJilI/+WRWlp38qO29WebSFUIsLGfLzdHoQ6HhHLbLz0hHD/lEN2lLT7m+sUbkZsiewQDIz9dUy7InPyB0rWAjAFPvaske2hUOtvJL1jAQKBgQDL4JclPuGJE4kg3pvps0/w2dFRkCWH9bl93j2FbIsDxNUl46LkEmeH53Vce7nH8GegCmJ3PZfRxyWF6XlpJ7JjJ5xvytHMHNzx7kUVub7TwwOS1yU6svXX0/VXbhJBWGJ1cCStU3lo2xMpY2bqbJWSymnGMHfyPPqWv9hTFAAoTQKBgQDAkGj0BTLJGY04rEQYMf4VfW1jndlNyMx1B2Lewkx8K1faT0KnHLgAXdmDTi22tl6CLmY2zFwSO2w6kRqyWDwSsmIIAWq0r/444HR568NoAyUhq7rLBcLqS7GJiHGPUXB5kD25gdyTTZPw7bFVlgufynOhivEsYBrWhV0V/LMmtQKBgDOEHK0cpoCsnwnfNiZnWNvTLkEd213viV90uLbuJnJdWj6otpBK1j5RDibAXMFYzdZyyU64EZTAbYrY5ATeMwU7DRxyc3DQGkRHoM1MkhuQO2bvVkjuz5ApzuS4u4QngTmLjLj/Tr5gHQdoRqkVpvXgj7m0pZpgLjHJaDAV7bRBAoGAAXvbYy37EzOgM/SX3bvc4luCEUdxGjlW4fv5lg/XOQm4dpUvxUviWxZeC7X5gjPrjINBBGEUwIs2rUja9M7bP6WiPb+NC/FjOxr3qszXR6Dmk1jYaqITu2xz5MRpY5pUDIvA/gHzKitp3Wxndmpeko+jznXcn+PpsQd8DSRSWRUCgYEAlGAwFX+C57R5sucucPnPTRit9XI67KOY1JcSHEGqOH4bUJrkpY3YMtjO9IGwvi+iPsp8oU9T2FN6tgxJ7BAVdrHl5v4wrLovvnTn/IIfQpwH4eGujpjSRu3LdETZQw8/J1AkOtwVglNa+8N79S4I938ckTKRJxMyG/nkV1FgBsk=";

        String data = RsaEncrypUtil.buildRSAEncryptByPublicKey(name, publickey);
        String sign = RsaEncrypUtil.buildRSASignByPrivateKey(data, privateKey);
        this.sign = sign;
        this.data = data;
        return data;
    }

}
