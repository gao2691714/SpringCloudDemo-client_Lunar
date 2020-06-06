package EncryOrDecry;

public class SM4EnClazz {

    public static void main(String[] args){
        SM4Utils utils = new SM4Utils();
        utils.setHexString(true);
        utils.setSecretKey("9ffb8d835b231e03380f1fb3249c002a");
        utils.setIv("79696B61746F6E6779696B61746F6E67");
//        String param = "{\"head\":{\"sys_tx_code\":\"P1792WX12\"},\"bodyCommon\":{\"com1\":{\"txn_insid\":\"111111111\",\"txn_itt_chnl_id\":\"009200000000001\",\"txn_itt_chnl_cgy_code\":\"30600092\",\"txn_stff_id\":\"11111111\"},\"com2\":{\"blng_inst_nm\":\"1\",\"lct_inst_lvl\":\"1\",\"empe_nm\":\"1\",\"pid\":\"1\",\"rl_ids\":[\"1\"]}},\"entity\":{\"WeChtSml_Prgm_Apl_Idr\":\"wx3cfbdaf835b720c6\",\"MblPh_No\":\"1588889967\",\"Tsk_ID\":\"4564564564\",\"Non_FAst_Mnt_InsID\":\"121144234234\",\"Kik_ID\":\"131231231\",\"Fcn_Tp_ID\":\"01\",\"TxnItt_ClntEnd_IP_Adr\":\"121212\",\"WrkOrdr_ID\":\"123123101\",\"Bsn_TpCd\":\"01\"}}";
        String param = "{'head':{'sys_tx_code':'P1792WX0F'},'bodyCommon':{'com1':{'txn_insid':'010220000','txn_itt_chnl_id':'0092wxjhitgj','txn_itt_chnl_cgy_code':'0922','txn_stff_id':'99999999'},'attachmentCom':{'file_num':'1','file_mode':'0','file_node':'','file_name_pack':'','file_path_pack':'','attachments':[{'file_name':'VCG.jpg','file_path':'/home/ap/nfamp/wxfiles/'}]}},'entity':{'WeChtSml_Prgm_Apl_Idr':'wx3cfbdaf835b720c6'}}";
        String back = utils.encryptData_CBC(param);
        System.out.println(back);
    }
}
