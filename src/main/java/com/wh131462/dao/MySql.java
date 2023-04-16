package com.wh131462.dao;

import org.jooq.*;
import org.jooq.impl.*;
import java.sql.Connection;

/**
 * todo 应该以pool 复用为主
 *
 */
public class MySql {
    public Connection connection = null;

    public MySql getConnection(String dataBase){
        //todo 建立连接
        return this;
    }
    public interface SqlCallback{
        void call(DSLContext context);
    }
    public MySql exec(SqlCallback callback){
        //todo 执行
        callback.call(DSL.using(this.connection, SQLDialect.MYSQL));
        return this;
    }

    /**
     * 关闭连接
     */
    public void close(){
        if (this.connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
//public static void main(String[] args) {
//    Connection connection = null;
//    try {
//        // Connect to the MySQL database
//        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "Qq54264047");
//
//        // Create a jOOQ context
//        DSLContext context = DSL.using(connection, SQLDialect.MYSQL);
//
//        // Insert a new record
//        context.insertInto(table("users"))
//                .set(field("name"), "John")
//                .set(field("age"), 30)
//                .execute();
//
//        // Update an existing record
//        context.update(table("users"))
//                .set(field("age"), 31)
//                .where(field("name").eq("John"))
//                .execute();
//
//        // Delete a record
//        context.deleteFrom(table("users"))
//                .where(field("name").eq("John"))
//                .execute();
//
//        // Select all records
//        Result<Record> result = context.select().from(table("users")).fetch();
//        for (Record r : result) {
//            String name = r.getValue("name", String.class);
//            int age = r.getValue("age", Integer.class);
//            System.out.printf("Name: %s, Age: %d\\\\n", name, age);
//        }
//    } catch (Exception e) {
//        e.printStackTrace();
//    } finally {
//        // Close the database connection
//        if (connection != null) {
//            try {
//                connection.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
