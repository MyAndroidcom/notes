### Linux用户权限
新建用户
useradd hadoop
passwd hadoop
mkdir /usr/hadoop
chown hadoop:hadoop /usr/hadoop -R
1.新建用户并赋于root权限,
方法一：修改 /etc/sudoers 文件，找到下面一行，把前面的注释（#）去掉
- ## Allows people in group wheel to run all commands
%wheel    ALL=(ALL)    ALL
然后修改用户，使其属于root组（wheel），命令如下：
- #usermod -g root tommy
修改完毕，现在可以用tommy帐号登录，然后用命令 su - ，即可获得root权限进行操作。
方法二：修改 /etc/sudoers 文件，找到下面一行，在root下面添加一行，如下所示：
- ## Allow root to run any commands anywhere
root    ALL=(ALL)     ALL
tommy   ALL=(ALL)     ALL
修改完毕，现在可以用tommy帐号登录，然后用命令 su - ，即可获得root权限进行操作。
2.用useradd新增的用户不能直接用ssh远程访问，需要修改ssh相关配置
如下：
vi /etc/ssh/sshd_config 
添加
AllowUsers root@192.168.1.32 admin
多个用户用空格隔开


### 常用操作
netstat  -nltp | grep 10000