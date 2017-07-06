package uk.route;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class Utility {

    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/uttarakhandrouteinfo";
    private static String username = "root";
    private static String password = "root";
    public static String searchFrom;
    public static String searchTo;

    public static ArrayList<String> getCities() {

        ArrayList<String> cities = new ArrayList<String>();

        String path = Utility.class.getResource("/uk/route/data/cities.txt").getPath();

        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(path));

            while (true) {
                String line = br.readLine();

                if (line == null || line.length() < 2) {
                    break;
                }

                cities.add(line);
            }

        } catch (Exception e) {
            System.out.println("Cities load error : " + e.getMessage());
            return null;
        } finally {
            try {
                br.close();
            } catch (Exception e) {
            }
        }

        return cities;
    }

    public static ArrayList<CityRoute> getPaths(String from, String to) {

        //ArrayList<CityRoute> routes = null;

        ArrayList<CityRoute> routes = getAllRoutes(from, to);
        /*
         if (destinationExists(tempRoutes, to)) {

         routes = new ArrayList<CityRoute>();

         for (CityRoute route : tempRoutes) {

         if (route.getTo().equals(to)) {
         routes.add(route);
         }
         }
         }
         */
        return routes;
    }

    public static String addPath(CityRoute route) {

        Connection con = null;			// stores connection information
        PreparedStatement st = null;			// executes queries

        // load the jdbc driver
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver error : " + e.getMessage());
            return null;
        } catch (SQLException e) {
            System.out.println("URL error : " + e.getMessage());
            return null;
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            return null;
        }

        try {
            String sql = "insert into cityroute(source,destination,distance,cityfrom,cityto,via) values(?,?,?,?,?,?)";

            st = con.prepareStatement(sql);
            st.setString(1, route.getSource());
            st.setString(2, route.getDestination());
            st.setDouble(3, route.getDistance());
            st.setString(4, route.getFrom());
            st.setString(5, route.getTo());
            st.setString(6, route.getVia());

            int recordsUpdated = st.executeUpdate();

            //check if any record is inserted
            if (recordsUpdated > 0) {
                return "success";
            } else {
                return "failed";
            }
        } catch (Exception e) {
            System.out.println("Unable to insert data : " + e.getMessage());
            return "error";
        } finally {

            try {
                st.close();
            } catch (Exception e2) {
            }

            try {
                con.close();
            } catch (Exception e2) {
            }
        }
    }

    public static ArrayList<CityRoute> getAllRoutes(String source, String to) {

        ArrayList<CityRoute> routes = null;

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        // load the jdbc driver
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver error : " + e.getMessage());
            return null;
        } catch (SQLException e) {
            System.out.println("URL error : " + e.getMessage());
            return null;
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            return null;
        }

        class Data {

            int entryid;
            public String cityfrom;
            public String cityto;
            public String via;
        }

        ArrayList<Data> ardata = null;

        try {
            String sql = "select entryid,cityfrom,cityto,via from cityroute where source='" + source + "' order by entryid";
System.out.println(sql);
            st = con.createStatement();
            rs = st.executeQuery(sql);

            if (rs.next()) {

                ardata = new ArrayList<Data>();

                do {
                    Data d = new Data();

                    d.entryid = rs.getInt("entryid");
                    d.cityfrom = rs.getString("cityfrom");
                    d.cityto = rs.getString("cityto");
                    d.via = rs.getString("via");

                    System.out.println(d.entryid + " , " + d.cityfrom + " , " + d.cityto + " , " + d.via);
                    
                    ardata.add(d);
                } while (rs.next());
            }

        } catch (Exception e) {
            System.out.println("Unable to read data : " + e.getMessage());
            e.printStackTrace();
            return null;
        } finally {

            st = null;
        }

        for (Data d : ardata) {

            int lastEntryId = getLastEntryId(d.cityfrom, d.cityto, d.via, to);

            if (lastEntryId != -1) {
                try {
                    String sql = "select entryid,source,destination,distance,cityfrom,cityto,via from cityroute where entryid>=" + d.entryid + " and entryid<=" + lastEntryId + " order by entryid";
                    System.out.println(sql);
                    
                    st = con.createStatement();
                    rs = st.executeQuery(sql);

                    if (rs.next()) {

                        routes = new ArrayList<CityRoute>();

                        do {
                            CityRoute route = new CityRoute();

                            route.setEntryid(rs.getInt("entryid"));
                            route.setSource(rs.getString("source"));
                            route.setDestination(rs.getString("destination"));
                            route.setDistance(rs.getDouble("distance"));
                            route.setFrom(rs.getString("cityfrom"));
                            route.setTo(rs.getString("cityto"));
                            route.setVia(rs.getString("via"));

                            routes.add(route);
                        } while (rs.next());
                    }

                } catch (Exception e) {
                    System.out.println("Unable to read data : " + e.getMessage());
                    e.printStackTrace();
                    return null;
                } finally {
                    st = null;
                }
            }

        }

        return routes;
    }

    private static int getLastEntryId(String cityfrom, String cityto, String cityvia, String dest) {

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        // load the jdbc driver
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver error : " + e.getMessage());
            return -1;
        } catch (SQLException e) {
            System.out.println("URL error : " + e.getMessage());
            return -1;
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            return -1;
        }

        int lastIndex = -1;

        try {
            String sql = "select entryid from cityroute where cityfrom='" + cityfrom + "' and cityto='" + cityto + "' and via='" + cityvia + "' and destination='" + dest + "'";
            System.out.println(sql);

            st = con.createStatement();
            rs = st.executeQuery(sql);

            if (rs.next()) {
                lastIndex = rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println("Unable to read data : " + e.getMessage());
            e.printStackTrace();
            return -1;
        } finally {

            try {
                st.close();
            } catch (Exception e2) {
            }
        }


        return lastIndex;
    }

    private static boolean destinationExists(ArrayList<CityRoute> routes, String to) {

        if (routes != null) {
            for (CityRoute route : routes) {

                if (route.getTo().equals(to)) {
                    return true;
                }
            }

            return false;
        } else {
            return false;
        }
    }

    public static void centerScreen(JFrame frame) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dim = toolkit.getScreenSize();

        int width = (int) dim.getWidth();
        int height = (int) dim.getHeight();

        frame.setLocation((width - frame.getWidth()) / 2, (height - frame.getHeight()) / 2);
    }

    public static void centerScreen(JDialog dialog) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dim = toolkit.getScreenSize();

        int width = (int) dim.getWidth();
        int height = (int) dim.getHeight();

        dialog.setLocation((width - dialog.getWidth()) / 2, (height - dialog.getHeight()) / 2);
    }

    public static boolean saveCityMapping(int x, int y, int width, int height, String city) {

        boolean saved = false;

        Connection con = null;			// stores connection information
        PreparedStatement st = null;			// executes queries

        // load the jdbc driver
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver error : " + e.getMessage());
            return false;
        } catch (SQLException e) {
            System.out.println("URL error : " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            return false;
        }

        try {
            String sql = "delete from citymapping where city=?";
            st = con.prepareStatement(sql);
            st.setString(1, city);
            st.executeUpdate();

            st.close();
            st = null;

            sql = "insert into citymapping(x,y,width,height,city) values(?,?,?,?,?)";

            st = con.prepareStatement(sql);
            st.setInt(1, x);
            st.setInt(2, y);
            st.setInt(3, width);
            st.setInt(4, height);
            st.setString(5, city);

            int recordsUpdated = st.executeUpdate();

            saved = recordsUpdated > 0;

        } catch (Exception e) {
            System.out.println("Unable to insert city mapping : " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {

            try {
                st.close();
            } catch (Exception e2) {
            }

            try {
                con.close();
            } catch (Exception e2) {
            }
        }

        return saved;
    }

    public static PointData getPointData(String city) {

        PointData point = null;

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        // load the jdbc driver
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver error : " + e.getMessage());
            return null;
        } catch (SQLException e) {
            System.out.println("URL error : " + e.getMessage());
            return null;
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            return null;
        }

        try {
            String sql = "select x,y,width,height from citymapping where city='" + city + "'";

            st = con.createStatement();
            rs = st.executeQuery(sql);

            if (rs.next()) {
                point = new PointData();

                int x = rs.getInt("x");
                int y = rs.getInt("y");
                int width = rs.getInt("width");
                int height = rs.getInt("height");

                point.startPoint = new Point(x, y);
                point.endPoint = new Point(width + x, height + y);
            }

        } catch (Exception e) {
            System.out.println("Unable to read data : " + e.getMessage());
            e.printStackTrace();
            return null;
        } finally {

            try {
                st.close();
            } catch (Exception e2) {
            }

            try {
                con.close();
            } catch (Exception e2) {
            }
        }

        return point;
    }

    public static void findSmallestRoute(ArrayList<Route> routes) {

        int small = findRouteDistance(routes.get(0));
        int position = 0;

        for (int i = 1; i < routes.size(); i++) {

            routes.get(i).setSmallest(false);

            int distance = findRouteDistance(routes.get(i));

            if (small > distance) {
                small = distance;
                position = i;
            }
        }

        routes.get(position).setSmallest(true);
    }

    private static int findRouteDistance(Route route) {

        int distance = 0;

        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        // load the jdbc driver
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver error : " + e.getMessage());
            return 0;
        } catch (SQLException e) {
            System.out.println("URL error : " + e.getMessage());
            return 0;
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            return 0;
        }

        try {
            String sql = "select sum(distance) from cityroute where cityfrom=? and cityto=? and via=?";

            st = con.prepareStatement(sql);
            st.setString(1, route.getFrom());
            st.setString(2, route.getTo());
            st.setString(3, route.getVia());

            rs = st.executeQuery();

            if (rs.next()) {
                distance = rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println("Unable to read distance : " + e.getMessage());
            e.printStackTrace();
            return 0;
        } finally {

            try {
                st.close();
            } catch (Exception e2) {
            }

            try {
                con.close();
            } catch (Exception e2) {
            }
        }

        return distance;
    }

    private static int findRouteDistance(String from, String to, String via) {

        int distance = 0;

        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        // load the jdbc driver
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver error : " + e.getMessage());
            return 0;
        } catch (SQLException e) {
            System.out.println("URL error : " + e.getMessage());
            return 0;
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            return 0;
        }

        try {
            String sql = "select sum(distance) from cityroute where cityfrom=? and cityto=? and via=?";

            st = con.prepareStatement(sql);
            st.setString(1, from);
            st.setString(2, to);
            st.setString(3, via);

            rs = st.executeQuery();

            if (rs.next()) {
                distance = rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println("Unable to read via : " + e.getMessage());
            e.printStackTrace();
            return 0;
        } finally {

            try {
                st.close();
            } catch (Exception e2) {
            }

            try {
                con.close();
            } catch (Exception e2) {
            }
        }

        return distance;
    }

    public static String findShortestVia(String from, String to) {

        int distance = -1;
        String via = null;

        ArrayList<String> vias = findAllVia(from, to);

        for (String tvia : vias) {

            int tdistance = findRouteDistance(from, to, tvia);

            if (distance == -1) {
                distance = tdistance;
                via = tvia;
            } else if (distance > tdistance) {
                distance = tdistance;
                via = tvia;
            }
        }

        return via;
    }

    private static ArrayList<String> findAllVia(String from, String to) {

        ArrayList<String> vias = new ArrayList<String>();

        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        // load the jdbc driver
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver error : " + e.getMessage());
            return null;
        } catch (SQLException e) {
            System.out.println("URL error : " + e.getMessage());
            return null;
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            return null;
        }

        try {
            String sql = "select distinct via from cityroute where cityfrom=? and cityto=?";

            st = con.prepareStatement(sql);
            st.setString(1, from);
            st.setString(2, to);

            rs = st.executeQuery();

            if (rs.next()) {
                do {
                    vias.add(rs.getString(1));
                } while (rs.next());
            }

        } catch (Exception e) {
            System.out.println("Unable to read distinct via : " + e.getMessage());
            e.printStackTrace();
            return null;
        } finally {

            try {
                st.close();
            } catch (Exception e2) {
            }

            try {
                con.close();
            } catch (Exception e2) {
            }
        }

        return vias;
    }

    static boolean isValidUser(String tusername, String tpassword) {

        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        boolean isValid = false;

        // load the jdbc driver
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver error : " + e.getMessage());
            return false;
        } catch (SQLException e) {
            System.out.println("URL error : " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            return false;
        }

        try {
            String sql = "select username from userinfo where username=? and password=?";

            st = con.prepareStatement(sql);
            st.setString(1, tusername);
            st.setString(2, tpassword);

            rs = st.executeQuery();

            isValid = rs.next();

        } catch (Exception e) {
            System.out.println("Unable to read distinct via : " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {

            try {
                st.close();
            } catch (Exception e2) {
            }

            try {
                con.close();
            } catch (Exception e2) {
            }
        }

        return isValid;
    }

    public static int getTotalDistance(Route route) {
        int n = 0;

        if (route != null && route.getPoints() != null) {
            n = route.getPoints().size();

            int totalsum = Kruskal.sum;
            return totalsum;
        } else {
            return 0;
        }
    }
}

class Kruskal {

    static int m[][] = new int[10][10];
    static int cost[][] = new int[10][10];
    static int a[][] = new int[10][10];
    static int b[] = new int[10];
    static int i, j, n = 0, k = 0;
    static int sum = 0;
    static int count = 0;

    static void set() throws IOException {
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                cost[i][j] = 11111;
                m[i][j] = 0;
            }
        }
    }

    static boolean sssp(int sour, int dest) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i, j;
        int distance[] = new int[20];
        int prev[] = new int[20];
        int prevmatrix[][] = new int[20][20];
        int source = sour;
        for (i = 0; i < n; i++) {
            prev[i] = source;
            if (i == source) {
                distance[i] = 11111;
            } else {
                distance[i] = cost[source][i];
            }
        }
        int t[] = new int[20];
        int temp[] = new int[20];
        int z = 0, min = source;
        int eachnode = 0;
        while (eachnode < n) {
            min = source;
            for (i = 0; i < n; i++) {
                if (distance[min] > distance[i]) {
                    min = i;
                }
            }
            t[z] = min;
            z++;
            temp[min] = distance[min];
            distance[min] = 11111;
            j = 0;

            for (j = 0; j < n; j++) {
                int min1 = 1;
                for (int k = 0; k < z; k++) {
                    if (j == t[k]) {
                        min1 = 0;
                    }
                }
                if ((j != min && j != source && min1 == 1)) {
                    if ((distance[j] > temp[min] + cost[min][j]) && cost[min][j] != 11111) {
                        distance[j] = temp[min] + cost[min][j];

                        prev[j] = min;
                    }
                }
            }
            eachnode++;
        }

        for (j = 0; j < n; j++) {
            if (temp[j] == 11111) {
                temp[j] = 0;
            }
            prevmatrix[source][j] = prev[j] + 1;
        }
        if (temp[dest] == 0) {
            return (false);
        } else {
            return (true);
        }
    }

    static void min() throws IOException {
        int i, j, minimum = 0, mini, t = 0, x = 0;
        sum = 0;
        mini = 1000;
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if (a[i][j] < mini && m[i][j] == 0) {
                    mini = a[i][j];
                    t = i;
                    x = j;
                    minimum = mini;
                }
            }
        }
        m[t][x] = 1;
        m[x][t] = 1;
        if (!sssp(t, x)) {
            cost[t][x] = minimum;
            cost[x][t] = minimum;
            count++;
        }

    }
}