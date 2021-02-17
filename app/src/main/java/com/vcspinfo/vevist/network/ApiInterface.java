package com.vcspinfo.vevist.network;

import com.vcspinfo.vevist.models.CSPDetailsResponse;
import com.vcspinfo.vevist.models.CSPDetailsListResponse;
import com.vcspinfo.vevist.models.CreateVisitResponse;
import com.vcspinfo.vevist.models.DashboardResponse;
import com.vcspinfo.vevist.models.LoginResonse;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @Headers("Content-Type: application/json")
    @POST("Login")
    Call<LoginResonse> login(@Query("login[username]") String userName,
                             @Query("login[password]") String password);

    @Headers("Content-Type: application/json")
    @GET("Dashboard/{token}")
    Call<DashboardResponse> getDashboard(@Path("token") String token);


    @Headers("Content-Type: application/json")
    @GET("GetCSPs/{token}")
    Call<CSPDetailsListResponse> getCspDetailsList(@Path("token") String token);

    @Headers("Content-Type: application/json")
    @GET("CSPDetails/{csp_code}")
    Call<CSPDetailsResponse> getCspDetails(@Path("csp_code") String csp_code);


    @Multipart
    @POST("CreateVisit")
    Call<CreateVisitResponse> creteVisit(
            @Part("visit[csp_code]") RequestBody csp_code,
            @Part("visit[option_sign_board]" ) RequestBody question101,
            @Part("visit[option_do_dont_banner]" ) RequestBody question102,
            @Part("visit[option_service_charge_banner]" ) RequestBody question103,
            @Part("visit[option_complaint_banner]" ) RequestBody question104,
            @Part("visit[option_working_hour]" ) RequestBody question105,
            @Part("visit[option_bcp_banner]" ) RequestBody question106,
            @Part("visit[option_pmjdy_banner]" ) RequestBody question107,
            @Part("visit[option_helpline_banner]" ) RequestBody question108,
            @Part("visit[option_counter_available]" ) RequestBody question109,
            @Part("visit[option_sitting_arrangement]" ) RequestBody question110,
            @Part("visit[option_ups]" ) RequestBody question111,
            @Part("visit[option_micro_atm]" ) RequestBody question112,
            @Part("visit[option_fake_note_detector]" ) RequestBody question113,
            @Part("visit[option_cctv]" ) RequestBody question114,
            @Part("visit[option_cctv_working]" ) RequestBody question115,
            @Part("visit[option_passbook_printer]" ) RequestBody question116,
            @Part("visit[option_multiple_terminal]" ) RequestBody question117,
            @Part("visit[option_voicemail_software]" ) RequestBody question118,
            @Part("visit[option_arogyasetu]" ) RequestBody question119,
            @Part("visit[option_handwash]" ) RequestBody question120,
            @Part("visit[option_cash_safe]" ) RequestBody question121,

            @Part("visit[option_transaction_register]" ) RequestBody question201,
            @Part("visit[option_account_open_register]" ) RequestBody question202,
            @Part("visit[option_aof_register]" ) RequestBody question203,
            @Part("visit[option_complaint_register]" ) RequestBody question204,
            @Part("visit[option_visitor_register]" ) RequestBody question205,
            @Part("visit[option_loan_application_register]" ) RequestBody question206,
            @Part("visit[option_contact_register]" ) RequestBody question207,
            @Part("visit[option_sss_register]" ) RequestBody question208,
            @Part("visit[option_authority_letter]" ) RequestBody question209,
            @Part("visit[option_agreement]" ) RequestBody question210,
            @Part("visit[date_agreement_valid]" ) RequestBody question211,
            @Part("visit[option_passbook]" ) RequestBody question212,
            @Part("visit[option_pan]" ) RequestBody question213,
            @Part("visit[option_aadhaar]" ) RequestBody question214,
            @Part("visit[option_marksheet]" ) RequestBody question215,
            @Part("visit[option_pvr_copy]" ) RequestBody question216,
            @Part("visit[date_pvr_valid]" ) RequestBody question217,
            @Part("visit[option_ddr_csp]" ) RequestBody question218,
            @Part("visit[option_kyc_referee]" ) RequestBody question219,
            @Part("visit[option_sworn_affidavit]" ) RequestBody question220,
            @Part("visit[option_bcp_testing]" ) RequestBody question221,
            @Part("visit[option_csp_id]" ) RequestBody question222,
            @Part("visit[option_csp_id_wear]" ) RequestBody question223,
            @Part("visit[option_subko_documents]" ) RequestBody question224,
            @Part("visit[option_single_folder]" ) RequestBody question225,

            @Part("visit[option_csp_location]" ) RequestBody question301,
            @Part("visit[option_customer_receipt]" ) RequestBody question302,
            @Part("visit[option_customer_sign]" ) RequestBody question303,
            @Part("visit[option_manual_withdraw]" ) RequestBody question304,
            @Part("visit[option_realtime_payment]" ) RequestBody question305,
            @Part("visit[option_stdr_tenk]" ) RequestBody question306,
            @Part("visit[option_fake_stdr]" ) RequestBody question307,
            @Part("visit[option_partial_payment]" ) RequestBody question308,
            @Part("visit[option_round_tip]" ) RequestBody question309,
            @Part("visit[option_extra_charge]" ) RequestBody question310,
            @Part("visit[option_other_atm]" ) RequestBody question311,
            @Part("visit[option_pmjdd]" ) RequestBody question312,
            @Part("visit[option_insurance]" ) RequestBody question313,
            @Part("visit[option_unauthorised]" ) RequestBody question314,
            @Part("visit[option_subko_longtime]" ) RequestBody question315,
            @Part("visit[option_more_csp]" ) RequestBody question316,
            @Part("visit[aof_count]" ) RequestBody question317,
            @Part("visit[aof_branch]" ) RequestBody question318,
            @Part("visit[complaint_csp_count]" ) RequestBody question319,


            @Part("visit[option_authority_letter]" ) RequestBody question401,
            @Part("visit[option_iibf]" ) RequestBody question402,
            @Part("visit[option_dra]" ) RequestBody question403,
            @Part("visit[option_training_certificate]" ) RequestBody question404,
            @Part("visit[option_any_other]" ) RequestBody question405,

            @Part("visit[total_accounts]" ) RequestBody question501,
            @Part("visit[rd]" ) RequestBody question502,
            @Part("visit[stdr]" ) RequestBody question503,
            @Part("visit[apy]" ) RequestBody question504,
            @Part("visit[pmjjby]" ) RequestBody question505,
            @Part("visit[pmsby]" ) RequestBody question506,
            @Part("visit[csp_working_days]" ) RequestBody question507,
            @Part("visit[csp_daily_count]" ) RequestBody question508,
            @Part("visit[pass_print_daily]" ) RequestBody question509,
            @Part("visit[total_npa]" ) RequestBody question510,
            @Part("visit[remarks_csp]" ) RequestBody question511,
            @Part("visit[remarks_visitor]" ) RequestBody question512,
            @Part("visit[option_visit_head]" ) RequestBody question513,
            @Part("visit[comments_head]" ) RequestBody comments_head,
            @Part("visit[option_visit_branch]" ) RequestBody question514,
            @Part("visit[comments_branch]" ) RequestBody comments_branch,

          //  @Part("visit[photo]" ) String photo

            @Part MultipartBody.Part file,
            @Part("visit[text_1]" ) RequestBody text_1,
            @Part("visit[text_2]" ) RequestBody text_2,
            @Part("token" ) RequestBody token

    );


}
