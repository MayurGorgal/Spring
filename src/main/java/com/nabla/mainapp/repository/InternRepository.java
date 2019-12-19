package com.nabla.mainapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.nabla.mainapp.Entity.InternInfoModel;

@Repository
public interface InternRepository extends MongoRepository<InternInfoModel, String>
{
	
	InternInfoModel findByEmail(String email);

}
