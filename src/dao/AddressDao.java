package dao;

import connection.MyConnection;
import dto.Address;

import java.sql.*;
import java.util.HashSet;

public class AddressDao {
    private Connection con;

    public AddressDao() {
        con = MyConnection.getConnection();
    }

    public Address getAddressbyId(int id) throws SQLException {
        String getAd = "select * from Address where id=?";
        PreparedStatement ps = con.prepareStatement(getAd);
        ps.setInt(1, id);
        ResultSet resultset = ps.executeQuery();
        if (resultset.next()) {
            return showAll(resultset);
        }
        return null;
    }

    public Address insertAddress(Address address) throws SQLException {
        String insert = "insert into address(state,city,street,postal_codee) values(?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(insert);

        ps.setString(1, address.getState());
        ps.setString(2, address.getCity());
        ps.setString(3, address.getStreet());
        ps.setString(4, address.getPostalCode());
        ps.executeUpdate();

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return showAll(rs);
        }
        ps.close();
        rs.close();
        return null;
    }

    public Address deleteAddress(int id) throws SQLException {
        Address deletedAddress = getAddressbyId(id);
        String delete = "delete from address where id=?";
        PreparedStatement ps = con.prepareStatement(delete);
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();

        return deletedAddress;
    }

    public Address updateAddress(int id, Address address) throws SQLException {
        String update = "update address set stat=?,city=?,street=?,postal_code=? where id=?";
        PreparedStatement ps = con.prepareStatement(update);
        ps.setString(1, address.getState());
        ps.setString(2, address.getCity());
        ps.setString(3, address.getStreet());
        ps.setString(4, address.getPostalCode());
        ps.setInt(5, id);

        ps.executeUpdate();
        ps.close();
        return getAddressbyId(id);

    }

    public HashSet<Address> allAddress() throws SQLException {
        HashSet<Address> addressSet = new HashSet<>();
        String select = "select * from address";
        PreparedStatement ps = con.prepareStatement(select);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Address adrs = showAll(rs);
            addressSet.add(adrs);
        }
        ps.close();
        return addressSet;
    }

    private Address showAll(ResultSet rs) throws SQLException {
        Address address = new Address();
        address.setState(rs.getString("state"));
        address.setCity(rs.getString("city"));
        address.setStreet(rs.getString("street"));
        address.setPostalCode(rs.getString("postal_code"));
        rs.close();

        return address;
    }
}