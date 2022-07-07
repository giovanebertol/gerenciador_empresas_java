package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

//@WebFilter(urlPatterns="/entrada")
public class MonitoramentoFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        long antes = System.currentTimeMillis();

        //executa a ação

        chain.doFilter(request, response);

        long depois = System.currentTimeMillis();
        
        System.out.println("Monitoramente Filter");
        System.out.println("Tempo de execução " + (depois - antes));

    }

}