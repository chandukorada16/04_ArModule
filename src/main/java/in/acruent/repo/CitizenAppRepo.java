package in.acruent.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.acruent.entity.CitizenApp;

public interface CitizenAppRepo extends JpaRepository<CitizenApp, Serializable> {

}
