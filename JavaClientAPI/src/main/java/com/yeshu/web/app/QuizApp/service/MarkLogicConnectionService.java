package com.yeshu.web.app.QuizApp.service;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.DatabaseClientFactory;
import com.marklogic.client.document.TextDocumentManager;
import com.marklogic.client.document.XMLDocumentManager;
import com.marklogic.client.io.StringHandle;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Getter
@Service
public class MarkLogicConnectionService {

        private final DatabaseClient client;
        private final XMLDocumentManager docMgr;

        public MarkLogicConnectionService() {
                client = DatabaseClientFactory.newClient("localhost", 8000, "Documents",
                        new DatabaseClientFactory.DigestAuthContext("admin", "admin"));
                docMgr = client.newXMLDocumentManager();
        }

        public void updateDocument(String docId, String xml) {

                StringHandle handle = new StringHandle();
                handle.set(xml);
                docMgr.write(docId, handle);
                client.release();
        }
}
