package com.util;

import java.util.ArrayList;
import java.util.List;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;
import com.entity.Product;

public class MemcachedUtil {
	static MemCachedClient memCachedClient=null;
	static String[] servers = {"127.0.0.1:11211"};
	static{
		memCachedClient = new MemCachedClient();
        SockIOPool pool = SockIOPool.getInstance();
		pool.setServers(servers);
		pool.setFailover( true );
		pool.setInitConn( 10 );
		pool.setMinConn( 5 );
		pool.setMaxConn( 150 );
		pool.setMaintSleep( 30 );
		pool.setNagle( false );
		pool.setSocketTO( 3000 );
		pool.setAliveCheck( true );
		pool.initialize();
	}
		public static void add(String name,List<Product> list){
			memCachedClient.set(name, list);
		}
		public static void del(String key) {
			memCachedClient.delete(key);
	    }

	    public static Object get(String key) {
	        return memCachedClient.get(key);
	    }
		public static void main(String[] args) {
			List<Product> list=new ArrayList<Product>();
			Product q=new Product();
			q.setName("qqq");
			Product w=new Product();
			w.setName("www");
			Product e=new Product();
			e.setName("eee");
			list.add(q);
			list.add(w);
			list.add(e);
			q.setName("11");
			add("zs", list);
			List<Product> xx=(List<Product>) get("zs");
			for(Product p:xx){
				System.out.println(p.getName());
			}
			
			List<Product> xxx =(List<Product>) get("xxx");
			for(Product p:xxx){
				System.out.println(p.getName());
			}
		}
}
