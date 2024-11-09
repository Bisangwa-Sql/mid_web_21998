package com.auca.library.controllers;

import com.auca.library.dao.LocationDAO;
import com.auca.library.models.Location;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/location")
public class LocationServlet extends HttpServlet {
    private final LocationDAO locationDAO = new LocationDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("locations", locationDAO.getAllLocations());
        request.getRequestDispatcher("/WEB-INF/views/locationList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String locationName = request.getParameter("locationName");
        if (locationName != null && !locationName.isEmpty()) {
            locationDAO.addLocation(new Location(locationName));
            response.sendRedirect("location");
        } else {
            response.sendRedirect("location.jsp?error=Invalid location name");
        }
    }
}
