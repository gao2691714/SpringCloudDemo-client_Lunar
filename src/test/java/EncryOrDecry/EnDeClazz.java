package EncryOrDecry;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

// 加解密类
public class EnDeClazz {
    private String UrlEn(String string){
        try {
            String ss =  URLEncoder.encode(string,"UTF-8");
            return ss;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String UrlDe(String string){
        try {
            String ss = URLDecoder.decode(string,"UTF-8");
            return ss;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args){
        EnDeClazz clazz = new EnDeClazz();
        //
//        String param = "2ZzZbHB627aPruVGJgqRjshBRspZGjE+aY/W4uJ3VYPUV7Pigv8qg3OE2KjBm6cDdbnZ498L344n9HGcrrtACq529Zj0dykBt7NWFo4ssTOnILaeHt5RcdgRAkm2PIBeevwxU/UEiXxHHYyPcHXPksOtMvrZTFPjGbJxIRGjz8gQ0bWtGut2mEl/vw/+GlVufrhzpLs7TfzRYzBWFNxBwbOuyCJzLGr+14yoHiKXjzPmnbrLSrKH/YlehjnR92y8w+46L1c0U0Ryaa/hR4EQ+dwAuTHaQE4qlL5avT8onaOi/2UyduEuH8lKI2PFnwaLIZ4mX/PU7GYiamjmvaG3jKr06UPb5xp1Z5fFz5RlRCV5xCMuTmvJzAGqcCOnLALa63TKKWythbfbAGA4Va9sPSwmCWX/oXXKDOeLUGWYT88aXqIO+SPJvjF8a2VjmTY4VZuAq1Zswid0fxMs5Vd5rzx3dXD4oHoBtZ0G/SSAdj03hBNygnhR35uzaBSLPzqvbgPXLLikCqNmj5lOqXXSfJNGfojYYmNGmV/0Z21dRM54fX4gxhlCIfBuvNfwTt9KWlmxmaBscnWA/TnTBpnNWnU25e10y+G1zk0dlcHgf/4=";
//        String param = "2ZzZbHB627aPruVGJgqRjshBRspZGjE+aY/W4uJ3VYPUV7Pigv8qg3OE2KjBm6cDdbnZ498L344n9HGcrrtACq529Zj0dykBt7NWFo4ssTOnILaeHt5RcdgRAkm2PIBeevwxU/UEiXxHHYyPcHXPksOtMvrZTFPjGbJxIRGjz8gQ0bWtGut2mEl/vw/+GlVufrhzpLs7TfzRYzBWFNxBwbOuyCJzLGr+14yoHiKXjzPmnbrLSrKH/YlehjnR92y8w+46L1c0U0Ryaa/hR4EQ+dwAuTHaQE4qlL5avT8onaOi/2UyduEuH8lKI2PFnwaLIZ4mX/PU7GYiamjmvaG3jKr06UPb5xp1Z5fFz5RlRCV5xCMuTmvJzAGqcCOnLALa63TKKWythbfbAGA4Va9sPSwmCWX/oXXKDOeLUGWYT88aXqIO+SPJvjF8a2VjmTY4VZuAq1Zswid0fxMs5Vd5r/2wr22XhJq9VtwzPdNtSUCVSedGazFgI08xBSyUV4rOp0py46r610J2o5AMc5w3W69dkaVrzwoUt/9N1NCDw8nEkFLAwUEo+Egltcye6kg1wexdfnL0DwA/XCUKdMqa4A==";
//        String param = "s59FiJBAtjkxLHbnDoYuEaXk1a9trCTDA2gwWeuEDdkjLaA7cg+bK0KkG1upjCDZF0xeapuA+jzolMc9FF97DdxkF1HPGQ7UAalC1b6KZfzyMGcx84FzBW8jHUICC+Retu/KDqK1RbM7AqTj9YahITn4CT14wBk6PmOm7yMVWAsoviHketCSrB0O/054mjPByxYKrBMAOZOFMPEM1NhGsUPlxd7lnADOZlog0s6ejiebaDurnZvu6GmL0eUVqIaVn8iwn2OFmLLyevPHSRkrtQUyac1NY4DVSElVBLpeAzLtr+0XjrY2ovOP2DncWqHzIKnUihOVfxDIVovvopBIscW6R2Baawb9w30Qyj0Tobn1YGfpwmnXhcTYjoR7NOKcCuxtvDKmmcUKiWogVCVdpNjjOl/1JgTK1P1cl8CypGVDpUP9FmOw/t+lt42Fy6PQSuWVTAXm3cZjnHXplmxvFauOES5fgVe7GArqnzUM95E0G5SGpTbNRc6YWLAEmw7G15ytvhW6SNvbe8ImwRsrjoDgBvm8W5pjeoszXFOr7vzSxzMEUffO6s/tpWDppiZgiztGKSM0mfON+gORxkf1rQ==";
//        String param = "2ZzZbHB627aPruVGJgqRjshBRspZGjE+aY/W4uJ3VYPUV7Pigv8qg3OE2KjBm6cDdbnZ498L344n9HGcrrtACq529Zj0dykBt7NWFo4ssTOnILaeHt5RcdgRAkm2PIBeNP1OK64awBI3BJJPIqg/WjQD3gjCOICYCnz9QQ+qRlO4N+xvRoviNDsgivlLkTRDQ0l+/pgAqGB3Rm906JAkt/7EV3Tw3MdA20VTirTFg2+A7kH91pL6S/vkYBJX7yyIh2S3CuzcM8CPZD0tvFgzVK1nmvHnMyBleEdmxec5YHpyJPDmLje9Qe1YZEGfrwt6MCgbqnNxzxRqX8S2PAsxN58WGFkq5wK2olmj3PfbKu1IYpVrPVRmNzYCqwQiDvbfiy4QMHQ9arE49OyxQva8Lsr5aNjQu/D7U16dvT9klJBMJkjLuIiewn1qN4U8J8yD6eihev3/BujnAO2KjEzzxjwQmxWI0Dp3HxoUbcq16+RDwiUAsE/qHQVGsb9UzH2ngo0DPgqrDoY2/8pMTe9Kys5BGCjj/5aL6n86tlDqAYxk+W2HBKvpD3/qX1Hvs+kM";
//        String param = "UazYC1QSRyKw1Pj52rz8ZGmFtWpwW0LwPRVBFYUuSA9nwtn16YKm3OPBY9+0R2t47fJ94kwuiRqn+Ug1VwSbUcVFaWvDGeic2KnMmATrRdOvnF9ejDtckBhLkCRdcvJT1ts/0N6RegSHNYnptQ0R/QzJD3ICvSETHcD1XzuhzT0IoOgyCAIYEnQ6sTi+LbpYS5Lti7artTuKoj2yq/Lp35iZzBXWmN2yrab2rBuqKOTU+PzPLso72LS7WDvB/HfWw6uQksmrQHPalYDUFxRuc/uDwM7TlZeJ6PYrLHlMBN16jwbJDLIhAUlI+ijyZT4OD8CdQeOGbPRRGv9YJX2oQKcw4tJeNXu8JxlUEyaGTBZToiZQ8S/arMW64KZ9xVielu6pD9bI8euuPUm0Iv3SC1OLUdyulkjYg23DjjpEn0eLoUWJvUpf/DoIr2gvcueGhMvqIGehPXrlMBOTr8SE13ZiZpzkmTYF25q1bP8uVjzgESvarm/jM8dNinL1rWK8ffCglKuaqKfedinLG8wiGc04tehazW4xPPsFwPiBdeAN1/9sY2fqO7ZiNN15kH4FA/MwErwDrf9fEyJ17+Qdi/90ggiRYdpC7iXNwqsmuYDcpxcA1F4GFgNiITMqMb34lVe+T3zsuZNpfvxAZqs1QpvK8cvQimQvwYeryqaj6tlLQbmnf6igmkIwq+kjjhGk";
        String param = "a8EktDmU70QQqlnEwCOnXUMgEj9M1M0VjLdx6z8MbpS69jSsg9RId5iDnH9jEydjWjvQGAA7AFHinTkf6G+qLXQhSHC2KcSw3YlhIhkB3TDIloRPupcwuzjuscdT6w/aQF8guRTigTLZypY8wVWjoSFVtaKg3LxzV8xZ5YzcYgDc4PuJ5/RgMSH+39MqObZDUvK+qkYa3xyFRXige6/uuRSVxMwNQMQbVonAKUs5zvMdV+jYrdNPFjlWRnZY4iIi6ct/ywCcto6dgg7moSgPX3fIfAOZXTilE9Agk//H9jG8PUAOXOydK5pkW8qpaIZdGJ26Yb+mLrH1Adscqs05BVzQ6/BZV5EgU9VAHAo0UbldH0EsRNivMz8RHR6jfNAi15cdcdnLTCmcM9rwA76ttsanl3VGyyHBAWzG1xtTLoTd1lz7lsVde1Q6B5ZIDXoeHDBP51J8BUXI6790isk1C5aZSzge97FfY86hXy8XD1K48ZZWTHEiEwkXOGQ1tTAWqyL+Rl8c1CrbQg1MJzRhOwjpoOtn4q+oL/7qW2xwQfQ=";
        System.out.println(clazz.UrlEn(param));

    }
}
