package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Event;

public class EventDAO {

	//----------初期情報----------
	private final String HOST ="localhost";//ホスト名
	private final String PORT ="5432";//ポート番号
	private final String DBNAME ="CarolinaReaper";//データベース名
	private String ROLENAME = "postgres";//ロール名
	private final String PASSWORD = "0000";//パスワード
	private final String URL = "jdbc:postgresql://" +HOST+":"+ PORT + "/" + DBNAME;

	//---------------- Methods----------------------------------------------------------------------------
	public  static String selectEventVenue(int index){//eventIDを入れてeventIDごとのEVENTVENUE TABLEのSELECT文を返す
		return "SELECT EVENTID , EVENTVENUE, EVENTVENUEID FROM EVENTVENUE"+ String.valueOf(index) ;
	}

	public static String selectAutherRemark (int index ){
		return "SELECT EVENTID , AUTHERREMARK, AUTHERREMARKID FROM AUTHERREMARK"+ String.valueOf(index) ;
	}

	public static String selectPricePerPerson (int index){
		return "SELECT EVENTID , PRICEPERPERSON, PRICEPERPERSONID FROM PRICEPERPERSON"+ String.valueOf(index) ;
	}

	public static String selectCandidate(int index){
		return "SELECT EVENTID , CANDIDATE, CANDIDATEID FROM PRICEPERPERSON"+ String.valueOf(index) ;
	}
	//public static String


	public  List<Event> getEventDB(){
		//----------接続パラメータ設定----------
		Connection conn = null;

		try {
			//--------------JDBCドライバ読み込み----------
			Class.forName("org.postgresql.Driver");

			//----------------DBに接続---------------------
			conn=DriverManager.getConnection(URL,ROLENAME,DBNAME);

			//----------SQL----------
			String selectEvent = "SELECT EVENTID, EVENTNAME, ORGANIZARNAME, REGISTDAY, AUTHERNAME, AUTHERPASS, DEADLINEDAY, DETERMINEDDAY, DETERMINEDFLAG, EVENTOPENFLAG, NUMBEROFEVENT, EVENTURL ,EVENTPAGEFILENAME FORM EVENT ORDER BY EVENTID DECS";
			ArrayList<String> selectEventVenue =new ArrayList<String>();



		//---------------------ここからエラー処理-----------------------
		} catch (SQLException e){
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e){
			e.printStackTrace();
			return null;
		} finally {
			//-----DB切断-----
			if(conn != null){
				try{
					conn.close();
				}catch(SQLException e){
					e.printStackTrace();
					return null;
				}
			}
		}
		//--------------------ここまでエラー処理---------------------------
		return null;//------returnしたいものを書け------

	}
}