package kz.aitu.oop.practice.assignment4;

import kz.aitu.oop.practice.assignment4.Controller.StoneController;
import kz.aitu.oop.practice.assignment4.Postgres.IIDB.IDB;
import kz.aitu.oop.practice.assignment4.Postgres.PostgresDB;
import kz.aitu.oop.practice.assignment4.Repositories.Irepo.StoneRepo;
import kz.aitu.oop.practice.assignment4.Repositories.Irepo.Interface.IRepo;

public class main {
    public static void main(String[] args)throws Exception {
        // running of our application
        IDB db = new PostgresDB();
        IRepo repo = new StoneRepo(db);
        StoneController controller = new StoneController(repo);
        FrontEnd app = new FrontEnd(controller);
        app.start();
    }
}
