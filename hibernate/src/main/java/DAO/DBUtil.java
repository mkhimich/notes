//package DAO;
//
//import javax.sql.DataSource;
//import java.sql.Connection;
//import java.sql.SQLException;
//
///**
// * Created by mkhimich on 8/5/16.
// */
//public class DBUtil {
//    private DataSource dataSource;
//
//    public DataSource getDataSource() {
//        return dataSource;
//    }
//
//    public void setDataSource(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
//
//    public void initialize() {
//        DataSource dataSource = getDataSource();
//        try {
//            Connection connection = dataSource.getConnection();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}
