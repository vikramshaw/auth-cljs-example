(defproject auth-cljs-example "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}

  :dependencies [[org.clojure/clojure "1.9.0"]
                 [ring/ring-jetty-adapter "1.8.0"]
                 [compojure "1.6.1"]
                 [org.clojure/clojurescript "1.10.520"]
                 [http-kit "2.3.0"]
                 [reagent "0.9.1"]
                 [hiccups "0.3.0"]
                 [ring/ring-json "0.5.0"]
                 [cljs-ajax "0.8.0"]]

  :main auth-cljs-example.core
  :source-paths ["src/clj" "src/cljs"]
  :resource-paths ["target" "resources"]

  :aliases {"fig" ["trampoline" "run" "-m" "figwheel.main"]
            "build-dev" ["trampoline" "run" "-m" "figwheel.main" "-b" "dev" "-r"]}

  :profiles
    {:dev
      {:dependencies [[binaryage/devtools "0.9.10"]
                      [cider/piggieback "0.4.2"]
                      [com.bhauman/figwheel-main "0.2.3"]
                      [com.bhauman/rebel-readline-cljs "0.1.4"]
                      [figwheel-sidecar "0.5.19"]]

       :main auth-cljs-example.core
       :cljsbuild
       {:builds {:login {:source-paths ["src/cljs"]
                        :figwheel true
                        :compiler
                        {:main auth-cljs-example.login
                         :asset-path "cljs-out/login"
                         :output-to "target/public/cljs-out/login-main.js"
                         :output-dir "target/public/cljs-out/login"
                         :source-map-timestamp true}}
                 :signup {:source-paths ["src/cljs"]
                         :figwheel true
                         :compiler
                         {:main auth-cljs-example.signup
                          :asset-path "cljs-out/login"
                          :output-to "target/public/cljs-out/login-main.js"
                          :output-dir "target/public/cljs-out/login"
                          :source-map-timestamp true}}}}

       :repl-options {:nrepl-middleware [cider.piggieback/wrap-cljs-repl]}
       ;; need to add the compliled assets to the :clean-targets
       :clean-targets ^{:protect false} ["target/public/cljs-out"
                                         :target-path]}})

