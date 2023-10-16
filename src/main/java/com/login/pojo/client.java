package com.login.pojo;

public class client {
    public String username;
    public String password;

    public String ip_address;
    public int port_number;

    public client(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public client(String username, String password, String ip_address, int port_number) {
        this.username = username;
        this.password = password;
        this.ip_address = ip_address;
        this.port_number = port_number;
    }

    public client() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIp_address() {
        return ip_address;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }

    public int getPort_number() {
        return port_number;
    }

    public void setPort_number(int port_number) {
        this.port_number = port_number;
    }

    @Override
    public String toString() {
        return "client{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", ip_address='" + ip_address + '\'' +
                ", port_number=" + port_number +
                '}';
    }
}
