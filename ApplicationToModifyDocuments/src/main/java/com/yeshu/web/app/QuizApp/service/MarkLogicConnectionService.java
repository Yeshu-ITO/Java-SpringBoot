package com.yeshu.web.app.QuizApp.service;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.DatabaseClientFactory;
import com.marklogic.client.document.XMLDocumentManager;
import com.marklogic.client.eval.EvalResult;
import com.marklogic.client.eval.EvalResultIterator;
import com.marklogic.client.eval.ServerEvaluationCall;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Getter
@Service
public class MarkLogicConnectionService {

        private final DatabaseClient client;
        private final XMLDocumentManager docMgr;

        //Constructor to create and connect to the marklogic server 
        public MarkLogicConnectionService() {
                client = DatabaseClientFactory.newClient("localhost", 8000, "JavaAPI",
                        new DatabaseClientFactory.DigestAuthContext("admin", "admin"));
                docMgr = client.newXMLDocumentManager();
        }

        //Method to list all the documents present the database
        public String allDocuments(String xquery) {
                ServerEvaluationCall eval = client.newServerEval();
                eval.xquery(xquery);
                EvalResultIterator resultIterator = eval.eval();
                StringBuilder result = new StringBuilder();
                while (resultIterator.hasNext()) {
                        EvalResult evalResult = resultIterator.next();
                        result.append(evalResult.getString()).append("\n");
                }
                System.out.println(result);
                return result.toString();
        }

        //Method to add a new node to all the documents in the database
        public String addNewNode(String xquery) {
                try{
                        ServerEvaluationCall eval = client.newServerEval();
                        eval.xquery(xquery);
                        eval.eval();
                        return "Added the new nodes";
                }
                catch(Exception e){
                        return "Some error occurred";
                }
        }
}

