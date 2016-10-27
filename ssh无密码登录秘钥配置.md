### ssh无密码登录秘钥配置
1.秘钥生成
ssh-keygen -t rsa
/home/hadoop/.ssh/id_rsa秘钥位置
ls -la
cd .ssh
cat id_rsa.pub > authorized_keys

若没有authorized_keys则在.ssh下面创建这个文件
chomd  600 authorized_keys
stop -yarn.sh
stopping nodemanager
stop-dfs.sh
修改主机名
vi /usr/hadoop/etc/hadoop/slaves


远程拷贝拷贝到另一台
scp id_rsa.pub  haddop02:home/hadoop/
加入授权列表
cat id_rsa.pub > authorized_keys 
chmod 600 authorized_keys
