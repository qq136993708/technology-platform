package org.pplus.system.provider;

/**
 * @author:Administrator
 * @date:2019/5/28
 */
public class User {
        private Integer id;
        private String type;
        private String name;

        public User(){}
        public User(Integer id,String type,String name){
            this.id = id;
            this.type = type;
            this.name = name;
        }

        public void setId(Integer id){
            this.id = id;
        }

        public Integer getId(){
            return id;
        }

        public void setType(String type){
            this.type = type;
        }

        public String getType(){
            return type;
        }

        public void setName(String name){
            this.name = name;
        }

        public String getName(){
            return name;
        }
}
