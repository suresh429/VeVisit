package com.vcspinfo.vevist.network;

import com.vcspinfo.vevist.models.CSPDetailsResponse;
import com.vcspinfo.vevist.models.CSPDetailsListResponse;
import com.vcspinfo.vevist.models.CreateVisitResponse;
import com.vcspinfo.vevist.models.DashboardResponse;
import com.vcspinfo.vevist.models.LoginResonse;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
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
    Call<List<CSPDetailsListResponse>> getCspDetailsList(@Path("token") String token);

    @Headers("Content-Type: application/json")
    @GET("CSPDetails/{csp_code}")
    Call<CSPDetailsResponse> getCspDetails(@Path("csp_code") String csp_code);


    @Headers("Content-Type: application/json")
    @POST("CreateVisit")
    Call<CreateVisitResponse> creteVisit(

            @Query("visit[csp_code]") String csp_code,
            @Query("visit[option_sign_board]" ) String question101,
            @Query("visit[option_do_dont_banner]" ) String question102,
            @Query("visit[option_service_charge_banner]" ) String question103,
            @Query("visit[option_complaint_banner]" ) String question104,
            @Query("visit[option_working_hour]" ) String question105,
            @Query("visit[option_bcp_banner]" ) String question106,
            @Query("visit[option_pmjdy_banner]" ) String question107,
            @Query("visit[option_helpline_banner]" ) String question108,
            @Query("visit[option_counter_available]" ) String question109,
            @Query("visit[option_sitting_arrangement]" ) String question110,
            @Query("visit[option_ups]" ) String question111,
            @Query("visit[option_micro_atm]" ) String question112,
            @Query("visit[option_fake_note_detector]" ) String question113,
            @Query("visit[option_cctv]" ) String question114,
            @Query("visit[option_cctv_working]" ) String question115,
            @Query("visit[option_passbook_printer]" ) String question116,
            @Query("visit[option_multiple_terminal]" ) String question117,
            @Query("visit[option_voicemail_software]" ) String question118,
            @Query("visit[option_arogyasetu]" ) String question119,
            @Query("visit[option_handwash]" ) String question120,
            @Query("visit[option_cash_safe]" ) String question121,

            @Query("visit[option_transaction_register]" ) String question201,
            @Query("visit[option_account_open_register]" ) String question202,
            @Query("visit[option_aof_register]" ) String question203,
            @Query("visit[option_complaint_register]" ) String question204,
            @Query("visit[option_visitor_register]" ) String question205,
            @Query("visit[option_loan_application_register]" ) String question206,
            @Query("visit[option_contact_register]" ) String question207,
            @Query("visit[option_sss_register]" ) String question208,
            @Query("visit[option_authority_letter]" ) String question209,
            @Query("visit[option_agreement]" ) String question210,
            @Query("visit[date_agreement_valid]" ) String question211,
            @Query("visit[option_passbook]" ) String question212,
            @Query("visit[option_pan]" ) String question213,
            @Query("visit[option_aadhaar]" ) String question214,
            @Query("visit[option_marksheet]" ) String question215,
            @Query("visit[option_pvr_copy]" ) String question216,
            @Query("visit[date_pvr_valid]" ) String question217,
            @Query("visit[option_ddr_csp]" ) String question218,
            @Query("visit[option_kyc_referee]" ) String question219,
            @Query("visit[option_sworn_affidavit]" ) String question220,
            @Query("visit[option_bcp_testing]" ) String question221,
            @Query("visit[option_csp_id]" ) String question222,
            @Query("visit[option_csp_id_wear]" ) String question223,
            @Query("visit[option_subko_documents]" ) String question224,
            @Query("visit[option_single_folder]" ) String question225,

            @Query("visit[option_csp_location]" ) String question301,
            @Query("visit[option_customer_receipt]" ) String question302,
            @Query("visit[option_customer_sign]" ) String question303,
            @Query("visit[option_manual_withdraw]" ) String question304,
            @Query("visit[option_realtime_payment]" ) String question305,
            @Query("visit[option_stdr_tenk]" ) String question306,
            @Query("visit[option_fake_stdr]" ) String question307,
            @Query("visit[option_partial_payment]" ) String question308,
            @Query("visit[option_round_tip]" ) String question309,
            @Query("visit[option_extra_charge]" ) String question310,
            @Query("visit[option_other_atm]" ) String question311,
            @Query("visit[option_pmjdd]" ) String question312,
            @Query("visit[option_insurance]" ) String question313,
            @Query("visit[option_unauthorised]" ) String question314,
            @Query("visit[option_subko_longtime]" ) String question315,
            @Query("visit[option_more_csp]" ) String question316,
            @Query("visit[aof_count]" ) String question317,
            @Query("visit[aof_branch]" ) String question318,
            @Query("visit[complaint_csp_count]" ) String question319,


            @Query("visit[option_authority_letter]" ) String question401,
            @Query("visit[option_iibf]" ) String question402,
            @Query("visit[option_dra]" ) String question403,
            @Query("visit[option_training_certificate]" ) String question404,
            @Query("visit[option_any_other]" ) String question405,

            @Query("visit[total_accounts]" ) String question501,
            @Query("visit[rd]" ) String question502,
            @Query("visit[stdr]" ) String question503,
            @Query("visit[apy]" ) String question504,
            @Query("visit[pmjjby]" ) String question505,
            @Query("visit[pmsby]" ) String question506,
            @Query("visit[csp_working_days]" ) String question507,
            @Query("visit[csp_daily_count]" ) String question508,
            @Query("visit[pass_print_daily]" ) String question509,
            @Query("visit[total_npa]" ) String question510,
            @Query("visit[remarks_csp]" ) String question511,
            @Query("visit[remarks_visitor]" ) String question512,
            @Query("visit[option_visit_head]" ) String question513,
            @Query("visit[comments_head]" ) String comments_head,
            @Query("visit[option_visit_branch]" ) String question514,
            @Query("visit[comments_branch]" ) String comments_branch,

            @Query("visit[photo]" ) String photo

    );


}
