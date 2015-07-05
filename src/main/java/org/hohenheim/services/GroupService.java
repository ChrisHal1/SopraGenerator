package org.hohenheim.services;

import java.util.List;

import org.hohenheim.model.entity.education.LGroup;
import org.hohenheim.model.repository.LGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupService extends BaseService {

	@Autowired
	private LGroupRepository groupRepository;
	
	public GroupService() {
		super();
	}
	
	public LGroup getGroup(String name){
		try {
			return this.groupRepository.getGroup(name);
		} catch (Exception e) {
			e.printStackTrace();
			return new LGroup();
		}
	}
	public boolean createGroup(String name){
		try {
			this.groupRepository.createGroup(this.getCurrentUserObject(), name);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean removeGroup(String name){
		try {
			return this.groupRepository.removeGroup(name);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<LGroup> getUsersGroups(String username){
		try {
			return this.groupRepository.getGroupsOfUser(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<LGroup> getOpenGroups(String username){
		try {
			return this.groupRepository.getOpenGroups(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<LGroup> search(String key){
		return this.groupRepository.search(key);
	}
}
