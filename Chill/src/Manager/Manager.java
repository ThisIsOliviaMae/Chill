package Manager;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Classes.Province;
import Classes.Region;
import Classes.Scholarship;
import Classes.School;

public class Manager
{
	public Manager()
	{
	}
	public ArrayList<Region> getAllRegions()
	{
		Connection conn = DBConnection.getConnection();
		ArrayList<Region> regions = new ArrayList<Region>();
		String sql = "SELECT region_id,region_name,region_designation FROM regions;";
		try
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next())
			{
				Region r = new Region();
				r.setRegion_id(rs.getInt("region_id"));
				r.setRegion_name(rs.getString("region_name"));
				r.setRegion_designation(rs.getString("region_designation"));
				regions.add(r);
			}
		} catch (SQLException e)
		{ // TODO Auto-generated catch block
			e.printStackTrace();
		}
		return regions;
	}
	public int getRegionID(String name)
	{
		int id=0;
		Connection conn = DBConnection.getConnection();
		String sql = "SELECT region_id FROM region WHERE region_name = ?";
		try
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next())
			{
				id = rs.getInt("region_id");
			}
		} catch (SQLException e)
		{ // TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
	public int getProvinceID(String name)
	{
		int id=0;
		Connection conn = DBConnection.getConnection();
		String sql = "SELECT province_id FROM province WHERE province_name = ?";
		try
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next())
			{
				id = rs.getInt("province_id");
			}
		} catch (SQLException e)
		{ // TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
	public ArrayList<Province> getAllProvinces()
	{
		Connection conn = DBConnection.getConnection();
		ArrayList<Province> provinces = new ArrayList<Province>();
		String sql = "SELECT province_id,province_name,region_name FROM provinces P, regions R WHERE R.region_id = P.region_id;";
		try
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next())
			{
				Province r = new Province();
				r.setProvince_id(rs.getInt("province_id"));
				r.setProvince_name(rs.getString("province_name"));
				r.setProvince_region(rs.getString("region_name"));
				provinces.add(r);
			}
		} catch (SQLException e)
		{ // TODO Auto-generated catch block
			e.printStackTrace();
		}
		return provinces;
	}
	public ArrayList<School> getAllSchools()
	{
		Connection conn = DBConnection.getConnection();
		ArrayList<School> schools = new ArrayList<School>();
		String sql = "SELECT school_id,school_name,school_address,province_name FROM provinces P, schools S where S.province_id=P.province_id;";
		try
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next())
			{
				School s = new School();
				s.setSchool_id(rs.getInt("school_id"));
				s.setSchool_name(rs.getString("school_name"));
				s.setSchool_address(rs.getString("school_address"));
				s.setProvince(rs.getString("province_name"));
				schools.add(s);
			}
		} catch (SQLException e)
		{ // TODO Auto-generated catch block
			e.printStackTrace();
		}
		return schools;
	}
	
	public ArrayList<School> getAllSchoolsByFilter(String region, String province, int type)
	{
		int i=1;
		Connection conn = DBConnection.getConnection();
		ArrayList<School> schools = new ArrayList<School>();
		String sql = "SELECT school_id,school_name,school_address,province_name FROM provinces P, schools S,regions R where S.province_id=P.province_id";
		if(region!="All")//by region
		{
			sql+=" and P.region_id = R.region_id and R.region_id = ?";
		}
		if(province!="All")//by region, province
		{
			sql+=" and S.province_id = ?";
		}
		if(type!=2)//by region, province, type
		{
			sql+=" and type = ?";
		}
		
		try
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			if(region!="All")//by region
			{
				ps.setInt(i, getRegionID(region));
				i++;
			}
			if(province!="All")//by region, province
			{
				ps.setInt(i, getProvinceID(province));
				i++;
			}
			if(type!=2)//by region, province, type
			{
				ps.setInt(i, type);
				i++;
			}
			ResultSet rs = ps.executeQuery();
			
			while (rs.next())
			{
				School s = new School();
				s.setSchool_id(rs.getInt("school_id"));
				s.setSchool_name(rs.getString("school_name"));
				s.setSchool_address(rs.getString("school_address"));
				s.setProvince(rs.getString("province"));
				schools.add(s);
			}
		} catch (SQLException e)
		{ // TODO Auto-generated catch block
			e.printStackTrace();
		}
		return schools;
	}
	
	public String getPricePerSchoolDegree(String degree, String school)
	{
		Connection conn = DBConnection.getConnection();
		String price="0";
		String sql="";
		if(degree =="BS"){
			sql="SELECT bs FROM schools S where and S.school_id = ?";
			degree = "bs";
		}
		else if(degree =="MS"){
			sql="SELECT master FROM schools S where S.school_id = ?";
			degree ="master";
		}
		else if(degree =="PHD"){
			sql="SELECT phd FROM schools S where S.school_id = ?";
			degree ="phd";
		}
		try
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, getSchoolID(school));
			ResultSet rs = ps.executeQuery();
			
			while (rs.next())
			{
				price = rs.getString(degree);
			}
		} catch (SQLException e)
		{ // TODO Auto-generated catch block
			e.printStackTrace();
		}
		return price; 
	}
	
	public int getSchoolID(String name)
	{
		int id=0;
		Connection conn = DBConnection.getConnection();
		String sql = "SELECT school_id FROM schools WHERE school_name = ?";
		try
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next())
			{
				id = rs.getInt("school_id");
			}
		} catch (SQLException e)
		{ // TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
	
	public ArrayList<Scholarship> getAllScholarships()
	{
		Connection conn = DBConnection.getConnection();
		ArrayList<Scholarship> scholarships = new ArrayList<Scholarship>();
		String sql = "SELECT scholar_id,scholar_name,scholar_description,link FROM scholarship SC";
		try
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next())
			{
				Scholarship s = new Scholarship();
				s.setScholarship_id(rs.getInt("scholar_id"));
				s.setScholarship_name(rs.getString("scholar_name"));
				s.setScholarship_description(rs.getString("scholar_description"));
				s.setScholarship_website(rs.getString("link"));
				scholarships.add(s);
			}
		} catch (SQLException e)
		{ // TODO Auto-generated catch block
			e.printStackTrace();
		}
		return scholarships;
	}
	
	public ArrayList<Scholarship> getAllScholarshipsBySchool(String school)
	{
		Connection conn = DBConnection.getConnection();
		ArrayList<Scholarship> scholarships = new ArrayList<Scholarship>();
		String sql = "SELECT scholar_id,scholar_name,scholar_description,link, school_name FROM scholarship SC, schools S where SC.school_id = S.school_id and S.school_id = ?";
		try
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next())
			{
				Scholarship s = new Scholarship();
				s.setScholarship_id(rs.getInt("scholar_id"));
				s.setScholarship_name(rs.getString("scholar_name"));
				s.setScholarship_description(rs.getString("scholar_description"));
				s.setScholarship_website(rs.getString("link"));
				s.setScholarship_school(rs.getString("school_name"));
				scholarships.add(s);
			}
		} catch (SQLException e)
		{ // TODO Auto-generated catch block
			e.printStackTrace();
		}
		return scholarships;
	}
}
