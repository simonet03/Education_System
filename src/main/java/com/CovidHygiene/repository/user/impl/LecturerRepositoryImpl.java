//package com.CovidHygiene.repository.user.impl;
//
//import com.CovidHygiene.entity.Lecturer;
//import com.CovidHygiene.repository.user.LecturerRepository;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class LecturerRepositoryImpl implements LecturerRepository {
//    private static LecturerRepository lecturerRepository = null;
//    private Set<Lecturer> lecturerDB;
//
//    private LecturerRepositoryImpl(){
//        this.lecturerDB = new HashSet<>();
//    }
//
//
//    public static LecturerRepository getLecturerRepository(){
//        if (lecturerRepository == null){
//            lecturerRepository = new LecturerRepositoryImpl();
//        }
//        return lecturerRepository;
//    }
//    @Override
//    public Set<Lecturer> getAll() {
//        return null;
//    }
//
//    @Override
//    public Lecturer create(Lecturer lecturer) {
//        this.lecturerDB.add(lecturer);
//        return lecturer;
//    }
//
//    @Override
//    public Lecturer read(String ID) {
//        for (Lecturer lecturer : this.lecturerDB){
//            if(lecturer.getLecturerNum().equalsIgnoreCase(ID)){
//                return lecturer;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public Lecturer update(Lecturer lecturer) {
//        boolean deleteLecturer = delete(lecturer.getLecturerNum());
//        if(deleteLecturer){
//            this.lecturerDB.add(lecturer);
//            return lecturer;
//        }
//        return null;
//    }
//
//    @Override
//    public boolean delete(String ID) {
//        Lecturer lecturer = read((ID));
//        if((lecturer != null)){
//            this.lecturerDB.remove(lecturer);
//            return true;
//        }
//        return false;
//    }
//}
