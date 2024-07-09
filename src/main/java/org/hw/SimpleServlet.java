package org.hw;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hw.repository.RandomPhraseStorage;

import java.io.IOException;

@WebServlet("/help-service/v1/support")
public class SimpleServlet extends HttpServlet {

    private RandomPhraseStorage phraseStorage;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.phraseStorage = new RandomPhraseStorage();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.getWriter().println(phraseStorage.randomGetPhrase());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        phraseStorage.addPhrase(req.getParameter("phrase"));
    }
}
