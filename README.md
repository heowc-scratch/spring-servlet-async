### spring-servlet-async

#### `/async`

```bash
http localhost:8080/async
```

```text
2020-12-21 21:27:14.269 DEBUG 35601 --- [nio-8080-exec-1] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped to com.example.SimpleController#async()
2020-12-21 21:27:14.278 DEBUG 35601 --- [nio-8080-exec-1] o.s.w.c.request.async.WebAsyncManager    : Started async request
2020-12-21 21:27:14.278 DEBUG 35601 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Exiting but response remains open for further handling
2020-12-21 21:27:14.278  INFO 35601 --- [      app-exec1] com.example.SimpleController             : async
2020-12-21 21:27:14.280 DEBUG 35601 --- [      app-exec1] o.s.w.c.request.async.WebAsyncManager    : Async result set, dispatch to /async
2020-12-21 21:27:14.283 DEBUG 35601 --- [nio-8080-exec-2] o.s.web.servlet.DispatcherServlet        : "ASYNC" dispatch for GET "/async", parameters={}
2020-12-21 21:27:14.284 DEBUG 35601 --- [nio-8080-exec-2] s.w.s.m.m.a.RequestMappingHandlerAdapter : Resume with async result ["async"]
2020-12-21 21:27:14.299 DEBUG 35601 --- [nio-8080-exec-2] m.m.a.RequestResponseBodyMethodProcessor : Using 'text/plain', given [*/*] and supported [text/plain, */*, text/plain, */*, application/json, application/*+json, application/json, application/*+json]
2020-12-21 21:27:14.299 DEBUG 35601 --- [nio-8080-exec-2] m.m.a.RequestResponseBodyMethodProcessor : Writing ["async"]
2020-12-21 21:27:14.306 DEBUG 35601 --- [nio-8080-exec-2] o.s.web.servlet.DispatcherServlet        : Exiting from "ASYNC" dispatch, status 200
```

#### `/sync`

```bash
http localhost:8080/sync 
```

```text
2020-12-21 21:29:05.640 DEBUG 35601 --- [nio-8080-exec-4] o.s.web.servlet.DispatcherServlet        : GET "/sync", parameters={}
2020-12-21 21:29:05.640 DEBUG 35601 --- [nio-8080-exec-4] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped to com.example.SimpleController#sync()
2020-12-21 21:29:05.641  INFO 35601 --- [nio-8080-exec-4] com.example.SimpleController             : sync
2020-12-21 21:29:05.641 DEBUG 35601 --- [nio-8080-exec-4] m.m.a.RequestResponseBodyMethodProcessor : Using 'text/plain', given [*/*] and supported [text/plain, */*, text/plain, */*, application/json, application/*+json, application/json, application/*+json]
2020-12-21 21:29:05.642 DEBUG 35601 --- [nio-8080-exec-4] m.m.a.RequestResponseBodyMethodProcessor : Writing ["sync"]
2020-12-21 21:29:05.643 DEBUG 35601 --- [nio-8080-exec-4] o.s.web.servlet.DispatcherServlet        : Completed 200 OK
```