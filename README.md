# GraphicsMatrix
## Class Matrix trong android là gì:
Là một class chứa một ma trận 3x3 dùng để biến đổi tọa độ 
## Các Hàm hay sử dụng
### set/pre/postTranslate(x,y):
Di chuyển tọa độ các điển,hình... được áp dụng Matrix một khoảng x,y 
### set/pre/postScale(sx,sy):
Thay đổi tọa độ các điểm,hình... theo tỉ lệ sx theo trục ox, sy theo trục oy với tâm là điểm 0,0
### set/pre/postScale(sx,sy,px,py):
Thay đổi tọa độ các điểm,hình... theo tỉ lệ sx theo trục ox, sy theo trục oy với tâm là điểm px,py
### set/pre/postRotate(d):
Xoay các điểm,hình... một góc d(tính bằng độ) với tâm là điểm 0,0
### set/pre/postRotate(d,px,py):
Xoay các điểm,hình... một góc d(tính bằng độ) với tâm là điểm px,py


