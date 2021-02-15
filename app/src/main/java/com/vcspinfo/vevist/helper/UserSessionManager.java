package com.vcspinfo.vevist.helper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

public class UserSessionManager {
    // Shared Preferences
    SharedPreferences pref;

    // Editor for Shared preferences
    SharedPreferences.Editor editor;

    // Context
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "ve_visit";

    // All Shared Preferences Keys
    public static final String KEY_IS_LOGGED_IN = "isLoggedIn";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_NAME = "name";
    public static final String KEY_MOBILE = "mobile";
    public static final String KEY_STATE = "state";
    public static final String KEY_ROLE = "role";
    public static final String KEY_TOKEN = "authentication_token";

    public static final String CSP_CODE = "csp_code";
    public static final String QUESTION_101 = "question_101";
    public static final String QUESTION_102 = "question_102";
    public static final String QUESTION_103 = "question_103";
    public static final String QUESTION_104 = "question_104";
    public static final String QUESTION_105 = "question_105";
    public static final String QUESTION_106 = "question_106";
    public static final String QUESTION_107 = "question_107";
    public static final String QUESTION_108 = "question_108";
    public static final String QUESTION_109 = "question_109";
    public static final String QUESTION_110 = "question_110";
    public static final String QUESTION_111 = "question_111";
    public static final String QUESTION_112 = "question_112";
    public static final String QUESTION_113 = "question_113";
    public static final String QUESTION_114 = "question_114";
    public static final String QUESTION_115 = "question_115";
    public static final String QUESTION_116 = "question_116";
    public static final String QUESTION_117 = "question_117";
    public static final String QUESTION_118 = "question_118";
    public static final String QUESTION_119 = "question_119";
    public static final String QUESTION_120 = "question_120";
    public static final String QUESTION_121 = "question_121";

    public static final String QUESTION_201 = "question_201";
    public static final String QUESTION_202 = "question_202";
    public static final String QUESTION_203 = "question_203";
    public static final String QUESTION_204 = "question_204";
    public static final String QUESTION_205 = "question_205";
    public static final String QUESTION_206 = "question_206";
    public static final String QUESTION_207 = "question_207";
    public static final String QUESTION_208 = "question_208";
    public static final String QUESTION_209 = "question_209";
    public static final String QUESTION_210 = "question_210";
    public static final String QUESTION_211 = "question_211";
    public static final String QUESTION_212 = "question_212";
    public static final String QUESTION_213 = "question_213";
    public static final String QUESTION_214 = "question_214";
    public static final String QUESTION_215 = "question_215";
    public static final String QUESTION_216 = "question_216";
    public static final String QUESTION_217 = "question_217";
    public static final String QUESTION_218 = "question_218";
    public static final String QUESTION_219 = "question_219";
    public static final String QUESTION_220 = "question_220";
    public static final String QUESTION_221 = "question_221";
    public static final String QUESTION_222 = "question_222";
    public static final String QUESTION_223 = "question_223";
    public static final String QUESTION_224 = "question_224";
    public static final String QUESTION_225 = "question_225";

    public static final String QUESTION_301 = "question_301";
    public static final String QUESTION_302 = "question_302";
    public static final String QUESTION_303 = "question_303";
    public static final String QUESTION_304 = "question_304";
    public static final String QUESTION_305 = "question_305";
    public static final String QUESTION_306 = "question_306";
    public static final String QUESTION_307 = "question_307";
    public static final String QUESTION_308 = "question_308";
    public static final String QUESTION_309 = "question_309";
    public static final String QUESTION_310 = "question_310";
    public static final String QUESTION_311 = "question_311";
    public static final String QUESTION_312 = "question_312";
    public static final String QUESTION_313 = "question_313";
    public static final String QUESTION_314 = "question_314";
    public static final String QUESTION_315 = "question_315";
    public static final String QUESTION_316 = "question_316";
    public static final String QUESTION_317 = "question_317";
    public static final String QUESTION_318 = "question_318";
    public static final String QUESTION_319 = "question_319";

    public static final String QUESTION_401 = "question_401";
    public static final String QUESTION_402 = "question_402";
    public static final String QUESTION_403 = "question_403";
    public static final String QUESTION_404 = "question_404";
    public static final String QUESTION_405 = "question_405";

    public static final String QUESTION_501 = "question_501";
    public static final String QUESTION_502 = "question_502";
    public static final String QUESTION_503 = "question_503";
    public static final String QUESTION_504 = "question_504";
    public static final String QUESTION_505 = "question_505";
    public static final String QUESTION_506 = "question_506";
    public static final String QUESTION_507 = "question_507";
    public static final String QUESTION_508 = "question_508";
    public static final String QUESTION_509 = "question_509";
    public static final String QUESTION_510 = "question_510";
    public static final String QUESTION_511 = "question_511";
    public static final String QUESTION_512 = "question_512";
    public static final String QUESTION_513 = "question_513";
    public static final String QUESTION_514 = "question_514";
    public static final String QUESTION_515 = "question_515";
    public static final String QUESTION_516 = "question_516";


    @SuppressLint("CommitPrefEdits")
    public UserSessionManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }


    public void createLogin(String username, String name, String mobile, String state, String role, String token) {
        editor.putString(KEY_USERNAME, username);
        editor.putString(KEY_NAME, name);
        editor.putString(KEY_MOBILE, mobile);
        editor.putString(KEY_STATE, state);
        editor.putString(KEY_ROLE, role);
        editor.putString(KEY_TOKEN, token);
        editor.putBoolean(KEY_IS_LOGGED_IN, true);
        editor.commit();
    }

    public void createInfra(String csp_code, String question_101,
                            String question_102,
                            String question_103,
                            String question_104,
                            String question_105,
                            String question_106,
                            String question_107,
                            String question_108,
                            String question_109,
                            String question_110,
                            String question_111,
                            String question_112,
                            String question_113,
                            String question_114,
                            String question_115,
                            String question_116,
                            String question_117,
                            String question_118,
                            String question_119,
                            String question_120,
                            String question_121


    ) {
        editor.putString(CSP_CODE, csp_code);
        editor.putString(QUESTION_101, question_101);
        editor.putString(QUESTION_102, question_102);
        editor.putString(QUESTION_103, question_103);
        editor.putString(QUESTION_104, question_104);
        editor.putString(QUESTION_105, question_105);
        editor.putString(QUESTION_106, question_106);
        editor.putString(QUESTION_107, question_107);
        editor.putString(QUESTION_108, question_108);
        editor.putString(QUESTION_109, question_109);
        editor.putString(QUESTION_110, question_110);
        editor.putString(QUESTION_111, question_111);
        editor.putString(QUESTION_112, question_112);
        editor.putString(QUESTION_113, question_113);
        editor.putString(QUESTION_114, question_114);
        editor.putString(QUESTION_115, question_115);
        editor.putString(QUESTION_116, question_116);
        editor.putString(QUESTION_117, question_117);
        editor.putString(QUESTION_118, question_118);
        editor.putString(QUESTION_119, question_119);
        editor.putString(QUESTION_120, question_120);
        editor.putString(QUESTION_121, question_121);


        editor.commit();
    }

    public void createDocumentation(

            String question_201,
            String question_202,
            String question_203,
            String question_204,
            String question_205,
            String question_206,
            String question_207,
            String question_208,
            String question_209,
            String question_210,
            String question_211,
            String question_212,
            String question_213,
            String question_214,
            String question_215,
            String question_216,
            String question_217,
            String question_218,
            String question_219,
            String question_220,
            String question_221,
            String question_222,
            String question_223,
            String question_224,
            String question_225


    ) {


        editor.putString(QUESTION_201, question_201);
        editor.putString(QUESTION_202, question_202);
        editor.putString(QUESTION_203, question_203);
        editor.putString(QUESTION_204, question_204);
        editor.putString(QUESTION_205, question_205);
        editor.putString(QUESTION_206, question_206);
        editor.putString(QUESTION_207, question_207);
        editor.putString(QUESTION_208, question_208);
        editor.putString(QUESTION_209, question_209);
        editor.putString(QUESTION_210, question_210);
        editor.putString(QUESTION_211, question_211);
        editor.putString(QUESTION_212, question_212);
        editor.putString(QUESTION_213, question_213);
        editor.putString(QUESTION_214, question_214);
        editor.putString(QUESTION_215, question_215);
        editor.putString(QUESTION_216, question_216);
        editor.putString(QUESTION_217, question_217);
        editor.putString(QUESTION_218, question_218);
        editor.putString(QUESTION_219, question_219);
        editor.putString(QUESTION_220, question_220);
        editor.putString(QUESTION_221, question_221);
        editor.putString(QUESTION_222, question_222);
        editor.putString(QUESTION_223, question_223);
        editor.putString(QUESTION_224, question_224);
        editor.putString(QUESTION_225, question_225);


        editor.commit();
    }


    public void createZeroTolerance(

            String question_301,
            String question_302,
            String question_303,
            String question_304,
            String question_305,
            String question_306,
            String question_307,
            String question_308,
            String question_309,
            String question_310,
            String question_311,
            String question_312,
            String question_313,
            String question_314,
            String question_315,
            String question_316,
            String question_317,
            String question_318,
            String question_319
    ) {


        editor.putString(QUESTION_301, question_301);
        editor.putString(QUESTION_302, question_302);
        editor.putString(QUESTION_303, question_303);
        editor.putString(QUESTION_304, question_304);
        editor.putString(QUESTION_305, question_305);
        editor.putString(QUESTION_306, question_306);
        editor.putString(QUESTION_307, question_307);
        editor.putString(QUESTION_308, question_308);
        editor.putString(QUESTION_309, question_309);
        editor.putString(QUESTION_310, question_310);
        editor.putString(QUESTION_311, question_311);
        editor.putString(QUESTION_312, question_312);
        editor.putString(QUESTION_313, question_313);
        editor.putString(QUESTION_314, question_314);
        editor.putString(QUESTION_315, question_315);
        editor.putString(QUESTION_316, question_316);
        editor.putString(QUESTION_317, question_317);
        editor.putString(QUESTION_318, question_318);
        editor.putString(QUESTION_319, question_319);


        editor.commit();
    }


    public void createCertifications(String question_401,
                                     String question_402,
                                     String question_403,
                                     String question_404,
                                     String question_405


    ) {

        editor.putString(QUESTION_401, question_401);
        editor.putString(QUESTION_402, question_402);
        editor.putString(QUESTION_403, question_403);
        editor.putString(QUESTION_404, question_404);
        editor.putString(QUESTION_405, question_405);

        editor.commit();
    }


    public void createActivities(
            String question_501,
            String question_502,
            String question_503,
            String question_504,
            String question_505,
            String question_506,
            String question_507,
            String question_508,
            String question_509,
            String question_510,
            String question_511,
            String question_512,
            String question_513,
            String question_514,
            String question_515,
            String question_516
    ) {

        editor.putString(QUESTION_501, question_501);
        editor.putString(QUESTION_502, question_502);
        editor.putString(QUESTION_503, question_503);
        editor.putString(QUESTION_504, question_504);
        editor.putString(QUESTION_505, question_505);
        editor.putString(QUESTION_506, question_506);
        editor.putString(QUESTION_507, question_507);
        editor.putString(QUESTION_508, question_508);
        editor.putString(QUESTION_509, question_509);
        editor.putString(QUESTION_510, question_510);
        editor.putString(QUESTION_511, question_511);
        editor.putString(QUESTION_512, question_512);
        editor.putString(QUESTION_513, question_513);
        editor.putString(QUESTION_514, question_514);
        editor.putString(QUESTION_515, question_515);
        editor.putString(QUESTION_516, question_516);


        editor.commit();
    }


    public boolean isLoggedIn() {
        return pref.getBoolean(KEY_IS_LOGGED_IN, false);
    }


    public void clearSession() {
        editor.clear();
        editor.commit();
    }

    public HashMap<String, String> getUserDetails() {
        HashMap<String, String> profile = new HashMap<>();
        profile.put("username", pref.getString(KEY_USERNAME, null));
        profile.put("name", pref.getString(KEY_NAME, null));
        profile.put("mobile", pref.getString(KEY_MOBILE, null));
        profile.put("state", pref.getString(KEY_STATE, null));
        profile.put("role", pref.getString(KEY_ROLE, null));
        profile.put("token", pref.getString(KEY_TOKEN, null));
        return profile;
    }


    public HashMap<String, String> getInfra() {
        HashMap<String, String> profile = new HashMap<>();
        profile.put("csp_code", pref.getString(CSP_CODE, null));
        profile.put("question_101", pref.getString(QUESTION_101, null));
        profile.put("question_102", pref.getString(QUESTION_102, null));
        profile.put("question_103", pref.getString(QUESTION_103, null));
        profile.put("question_104", pref.getString(QUESTION_104, null));
        profile.put("question_105", pref.getString(QUESTION_105, null));
        profile.put("question_106", pref.getString(QUESTION_106, null));
        profile.put("question_107", pref.getString(QUESTION_107, null));
        profile.put("question_108", pref.getString(QUESTION_108, null));
        profile.put("question_109", pref.getString(QUESTION_109, null));
        profile.put("question_110", pref.getString(QUESTION_110, null));
        profile.put("question_111", pref.getString(QUESTION_111, null));
        profile.put("question_112", pref.getString(QUESTION_112, null));
        profile.put("question_113", pref.getString(QUESTION_113, null));
        profile.put("question_114", pref.getString(QUESTION_114, null));
        profile.put("question_115", pref.getString(QUESTION_115, null));
        profile.put("question_116", pref.getString(QUESTION_116, null));
        profile.put("question_117", pref.getString(QUESTION_117, null));
        profile.put("question_118", pref.getString(QUESTION_118, null));
        profile.put("question_119", pref.getString(QUESTION_119, null));
        profile.put("question_120", pref.getString(QUESTION_120, null));
        profile.put("question_121", pref.getString(QUESTION_121, null));


        return profile;
    }

    public HashMap<String, String> getDocumentation() {
        HashMap<String, String> profile = new HashMap<>();


        profile.put("question_201", pref.getString(QUESTION_201, null));
        profile.put("question_202", pref.getString(QUESTION_202, null));
        profile.put("question_203", pref.getString(QUESTION_203, null));
        profile.put("question_204", pref.getString(QUESTION_204, null));
        profile.put("question_205", pref.getString(QUESTION_205, null));
        profile.put("question_206", pref.getString(QUESTION_206, null));
        profile.put("question_207", pref.getString(QUESTION_207, null));
        profile.put("question_208", pref.getString(QUESTION_208, null));
        profile.put("question_209", pref.getString(QUESTION_209, null));
        profile.put("question_210", pref.getString(QUESTION_210, null));
        profile.put("question_211", pref.getString(QUESTION_211, null));
        profile.put("question_212", pref.getString(QUESTION_212, null));
        profile.put("question_213", pref.getString(QUESTION_213, null));
        profile.put("question_214", pref.getString(QUESTION_214, null));
        profile.put("question_215", pref.getString(QUESTION_215, null));
        profile.put("question_216", pref.getString(QUESTION_216, null));
        profile.put("question_217", pref.getString(QUESTION_217, null));
        profile.put("question_218", pref.getString(QUESTION_218, null));
        profile.put("question_219", pref.getString(QUESTION_219, null));
        profile.put("question_220", pref.getString(QUESTION_220, null));
        profile.put("question_221", pref.getString(QUESTION_221, null));
        profile.put("question_222", pref.getString(QUESTION_222, null));
        profile.put("question_223", pref.getString(QUESTION_223, null));
        profile.put("question_224", pref.getString(QUESTION_224, null));
        profile.put("question_225", pref.getString(QUESTION_225, null));


        return profile;
    }

    public HashMap<String, String> getZeroTolerance() {
        HashMap<String, String> profile = new HashMap<>();


        profile.put("question_301", pref.getString(QUESTION_301, null));
        profile.put("question_302", pref.getString(QUESTION_302, null));
        profile.put("question_303", pref.getString(QUESTION_303, null));
        profile.put("question_304", pref.getString(QUESTION_304, null));
        profile.put("question_305", pref.getString(QUESTION_305, null));
        profile.put("question_306", pref.getString(QUESTION_306, null));
        profile.put("question_307", pref.getString(QUESTION_307, null));
        profile.put("question_308", pref.getString(QUESTION_308, null));
        profile.put("question_309", pref.getString(QUESTION_309, null));
        profile.put("question_310", pref.getString(QUESTION_310, null));
        profile.put("question_311", pref.getString(QUESTION_311, null));
        profile.put("question_312", pref.getString(QUESTION_312, null));
        profile.put("question_313", pref.getString(QUESTION_313, null));
        profile.put("question_314", pref.getString(QUESTION_314, null));
        profile.put("question_315", pref.getString(QUESTION_315, null));
        profile.put("question_316", pref.getString(QUESTION_316, null));
        profile.put("question_317", pref.getString(QUESTION_317, null));
        profile.put("question_318", pref.getString(QUESTION_318, null));
        profile.put("question_319", pref.getString(QUESTION_319, null));


        return profile;
    }

    public HashMap<String, String> getCertificates() {
        HashMap<String, String> profile = new HashMap<>();


        profile.put("question_401", pref.getString(QUESTION_401, null));
        profile.put("question_402", pref.getString(QUESTION_402, null));
        profile.put("question_403", pref.getString(QUESTION_403, null));
        profile.put("question_404", pref.getString(QUESTION_404, null));
        profile.put("question_405", pref.getString(QUESTION_405, null));


        return profile;
    }

    public HashMap<String, String> getActivities() {
        HashMap<String, String> profile = new HashMap<>();

        profile.put("question_501", pref.getString(QUESTION_501, null));
        profile.put("question_502", pref.getString(QUESTION_502, null));
        profile.put("question_503", pref.getString(QUESTION_503, null));
        profile.put("question_504", pref.getString(QUESTION_504, null));
        profile.put("question_505", pref.getString(QUESTION_505, null));
        profile.put("question_506", pref.getString(QUESTION_506, null));
        profile.put("question_507", pref.getString(QUESTION_507, null));
        profile.put("question_508", pref.getString(QUESTION_508, null));
        profile.put("question_509", pref.getString(QUESTION_509, null));
        profile.put("question_510", pref.getString(QUESTION_510, null));
        profile.put("question_511", pref.getString(QUESTION_511, null));
        profile.put("question_512", pref.getString(QUESTION_512, null));
        profile.put("question_513", pref.getString(QUESTION_513, null));
        profile.put("question_514", pref.getString(QUESTION_514, null));
        profile.put("question_515", pref.getString(QUESTION_515, null));
        profile.put("question_516", pref.getString(QUESTION_516, null));


        return profile;
    }


}
