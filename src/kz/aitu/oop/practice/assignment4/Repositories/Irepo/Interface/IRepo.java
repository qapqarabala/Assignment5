package kz.aitu.oop.practice.assignment4.Repositories.Irepo.Interface;

import kz.aitu.oop.practice.assignment4.Entities.Stone;

import java.util.List;

public interface IRepo {
    boolean createStones(Stone stone);
    List<Stone> seeStones();
    Stone deleteStones(int id);
    int jewelryCost();
    int jewelryWeight();
}
