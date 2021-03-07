package kz.aitu.oop.practice.assignment4.Controller;

import kz.aitu.oop.practice.assignment4.Entities.Stone;
import kz.aitu.oop.practice.assignment4.Repositories.Irepo.Interface.IRepo;

import java.util.List;


public class StoneController {
        private final IRepo repo;
        public StoneController(IRepo repo) {
            this.repo = repo;
        }
        public String createStones(int id,String name, String value,int cost, int weight) {

            Stone stone = new Stone(id,name,value,cost,weight);

            boolean created = repo.createStones(stone);

            return (created ? "Stone was created!" : "Stone creation was failed!");
        }

        public String deleteStones(int id) {
            Stone stone = repo.deleteStones(id);

            return (stone == null ? " " : stone.toString());
        }

        public String seeStones() {
            List<Stone> stone = repo.seeStones();
            return stone.toString();
        }
    public int jewelryCost(){
        int response = repo.jewelryCost();
        return response;
    }
    public int jewelryWeight(){
        int response1 = repo.jewelryWeight();
        return response1;
    }
    }
