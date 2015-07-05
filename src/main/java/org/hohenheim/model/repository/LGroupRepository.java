package org.hohenheim.model.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.hohenheim.model.entity.education.LGroup;
import org.hohenheim.model.entity.user.User;
import org.hohenheim.util.helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LGroupRepository extends BaseRepository<LGroup> {

	@Autowired
	private UserRepository userRepository;
	
	public LGroupRepository(){
		super();
	}
	
	public LGroup getGroup(String name){
		return (LGroup)this.getByUniqueAttribute("name", name);
	}
	
	public boolean createGroup(User createdBy, String name) throws Exception{
		LGroup newgroup = new LGroup(createdBy, name);
		
		return this.save(newgroup);
	}
	
	public boolean removeGroup(String name) throws Exception{
		
		return this.delete(this.getGroup(name));
	}
	
	public List<LGroup> getAllGroups(boolean OrderedByCreation) throws Exception{
		return (List<LGroup>)this.getAllObjectsFromTable(OrderedByCreation);
	}
	/*
	 * ID = the id of the current user
	 */
	public List<LGroup> getGroupsOfUser(String username) throws Exception{
		
		User user = this.userRepository.getByUniqueAttribute("username", username);
		
		if(user != null)
			return user.groups;
		else
			return new ArrayList<LGroup>();
	}
	
	/*
	 * ID = the id of the current user
	 * */
	
	public List<LGroup> getOpenGroups(String username) throws Exception{
		
		List<LGroup> groups = this.getAllGroups(true);
		
		User user = this.userRepository.getByUniqueAttribute("username", username);
		
		for(int i = 0; i < user.groups.size(); i++){
			if(groups.contains(user.groups.get(i)))
				groups.remove(user.groups.get(i));
		}
		
		return groups;
	}
	
	public List<LGroup> search(String key){
		return this.runQuery("FROM LGroup WHERE name LIKE '%" + key + "%'");
	}
	
	public boolean addMemberToGroup(LGroup group, User member){
		if(group.isFull())
			return false;

		group.addMember(member);
		return true;
	}
	
	public void removeMemberFromGroup(LGroup group, User member){
		group.removeMember(member);
	}
}