# encoding:utf-8
import cv2
import sys
# 调用笔记本内置摄像头，参数为0，如果有其他的摄像头可以调整参数为1,2
cap = cv2.VideoCapture(0)
# 调用人脸分类器，要根据实际路径调整
face_detector = cv2.CascadeClassifier('H:/project/untitled/haarcascade_frontalface_default.xml')
# 为即将录入的脸标记一个id
# face_id = input('\n User data input,Look at the camera and wait ...')
face_id = int(sys.argv[1])
# face_id = 0
# sampleNum用来计数样本数目

count = 0
f = open('H:/project/untitled/data/maxCount.txt', 'a+')
f.seek(0)
fs = f.readline()
while fs != "":
    fid = int(fs.split()[0])
    fcount = int(fs.split()[1])
    if fid == face_id:
        count = fcount
        break
    fs = f.readline()
if count == 0:
    fs = str(face_id) + " 0" + '\n'
    f.write(fs)
f.close()

while True:
    # 从摄像头读取图片
    success, img = cap.read()
    # 转为灰度图片，减少程序符合，提高识别度
    if success is True:
        gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
    else:
        break
    # 检测人脸，将每一帧摄像头记录的数据带入OpenCv中，让Classifier判断人脸
    # 其中gray为要检测的灰度图像，1.3为每次图像尺寸减小的比例，5为minNeighbors
    faces = face_detector.detectMultiScale(gray, 1.3, 5)

    # 框选人脸，for循环保证一个能检测的实时动态视频流
    for (x, y, w, h) in faces:
        # xy为左上角的坐标,w为宽，h为高，用rectangle为人脸标记画框
        cv2.rectangle(img, (x, y), (x+w, y+w), (255, 0, 0))
        # 成功框选则样本数增加
        count += 1
        # 保存图像，把灰度图片看成二维数组来检测人脸区域
        # (这里是建立了data的文件夹，当然也可以设置为其他路径或者调用数据库)
        cv2.imwrite("H:/project/untitled/data/User."+str(face_id)+'.'+str(count)+'.jpg', gray[y:y+h, x:x+w])
        # 显示图片
        cv2.imshow('image', img)
        # 保持画面的连续。waitkey方法可以绑定按键保证画面的收放，通过q键退出摄像
    k = cv2.waitKey(1)
    if k == 27:
        break
        # 或者得到800个样本后退出摄像，这里可以根据实际情况修改数据量，实际测试后800张的效果是比较理想的
    elif count >= 800:
        break

f = open('H:/project/untitled/untitled/data/maxCount.txt', 'a+')
new_stus = ""
f.seek(0)
for s in f:
    fid = int(s.split()[0])
    if fid == face_id:
        s = str(fid) + " " + str(count) + '\n'
    new_stus = new_stus + s
f.seek(0)
f.truncate()
f.write(new_stus)
f.flush()
f.close()

# 调用trainer.py
# os.system("/Users/songminhui/PycharmProjects/untitled/venv/bin/python "
#           "/Users/songminhui/PycharmProjects/untitled/trainer.py")

# 关闭摄像头，释放资源
cap.release()
cv2.destroyAllWindows()

