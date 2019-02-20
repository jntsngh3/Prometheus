//
//PrometheusMeterRegistry meterRegistry = new PrometheusMeterRegistry(PrometheusConfig.DEFAULT);
//        meterRegistry.config().meterFilter(new PrometheusRenameFilter());
//        new ClassLoaderMetrics().bindTo(registry);
//        try{
//        HttpServer server = HttpServer.create(new InetSocketAddress("localhost",8080), 0);
//        server.createContext("/Test_war_exploded/metrics", httpExchange -> {
//        String res = meterRegistry.scrape();
//        System.out.println(res);
//        httpExchange.sendResponseHeaders(200, res.getBytes().length);
//        try(OutputStream os = httpExchange.getResponseBody()) {
//        os.write(1232);
//        os.write(res.getBytes());
//        }
//        });
//        new Thread(server::start).start();
//        }catch (IOException e){
//        System.out.println(e);
//        e.printStackTrace(System.err);
//        }

//MeterRegistry registry = new SimpleMeterRegistry();
//        registry.config().commonTags("application", "TestServlet");