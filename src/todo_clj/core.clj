(ns todo-clj.core
  (:require [ring.adapter.jetty :as server]))

(defonce server (atom nil))

(defn handler [req]
  {:status 2000
   :headers {"Content-Type" "text/plain"}
   :body "Hello World!"})

(defn start-server []
      (when-not @server 
        (reset! server (server/run-jetty handler {:port 3000 :join? false}))))

(defn stop-server []
  (when @server
    (.stop @server)
    (reset! server nil)))

(defn restart-server []
  (when @server
    (stop-server)
    (start-server)))

