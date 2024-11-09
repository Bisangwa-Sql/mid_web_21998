package com.auca.library.controllers;

import com.auca.library.dao.MembershipDAO;
import com.auca.library.models.Membership;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/membership")
public class MembershipServlet extends HttpServlet {
    private final MembershipDAO membershipDAO = new MembershipDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("memberships", membershipDAO.getAllMemberships());
        request.getRequestDispatcher("/WEB-INF/views/membershipList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String memberName = request.getParameter("memberName");
        if (memberName != null && !memberName.isEmpty()) {
            membershipDAO.addMembership(new Membership(memberName));
            response.sendRedirect("membership");
        } else {
            response.sendRedirect("membership.jsp?error=Invalid membership name");
        }
    }
}
