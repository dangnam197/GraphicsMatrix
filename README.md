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

### set/pre/postSkew(kx,ky):
Thay đổi độ nghiêng của điểm,hình theo tỉ lệ kx theo trục x và ky theo trục y với tâm là điểm 0,0

### set/pre/postSkew(kx,ky,px,py):
Thay đổi độ nghiêng của điểm,hình theo tỉ lệ kx theo trục x và ky theo trục y với tâm là điểm px,py

## sự khác nhau giữa set/pre/post
 Khi chỉ sử dụng 1 hàm cả 3 đều cho ra kết quả giống nhau giống nhau
 Khi sử dụng nhiều hàm liên tiếp :
 - set: loại bỏ tất cả thay đổi trước đó và chỉ đặt giá trị mới vào matrix
 - pre: matrix mới bằng  M '= M * matrix biến đổi ( hiểu đơn giản những hàm pre sẽ được app dụng trước vd: thứ tự gọi setScale,preRotate,preTranslate thì thứ tự áp dụng translate -> rotate -> scale)
- post:  matrix mới bằng M ' = matrix biến đổi * M ( hiểu đơn giản hàm post sẽ áp dụng lận lượt theo thứ tự như mình gọi)

Thứ tự áp dụng pre -> set -> post (vd: thứ tự gọi setTranslate,postScale,preRotate thì thứ tự áp dụng sẽ là rotate -> translate -> scale

## 	mapPoints(pts: FloatArray!):
Áp dụng ma trận cho mảng này để biến nó thanh giá trị mới ( mảng theo căp giá trị [x0,y0,x1,y1,...] )

## mapPoints(dst: FloatArray!, src: FloatArray!)
Áp dụng ma trận cho mảng src, giá trị sau khi biến đổi sẽ được set vào mảng dst (mảng src giá trị không đổi, 2 mảng này phải có kích thước bằng nhau)

##  mapPoints(dst: FloatArray!,  dstIndex: Int,   src: FloatArray!,   srcIndex: Int,  pointCount: Int)
Áp dụng ma trận cho mảng src, giá trị sau khi biến đổi sẽ được set vào mảng dst với srcIndex là vị trí cặp đầu tiên được áp dụng ma trận, dstIndex là vị trí lưu cặp đầu tiên , point count số cặp src được áp dụng ma trận (pointCoun <= src.length/2 - srcIndex) 

## mapRect(rect: RectF!):
Áp dụng ma trận cho rect và thay đổi giá trị của nó

## mapRect( dst: RectF!,src: RectF!)
Áp dụng ma trận cho src sau khi ap dụng giá trị của src giữ nguyên kết quả lưu vào dst

## mapRadius(radius: Float): Float
Trả về bán kính hình tròn sau khi áp dụng ma trận






