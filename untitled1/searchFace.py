# encoding='utf-8'
import base64
import sys

from aip import AipFace


def tobase64(path):
    with open(path, "rb") as f:
        base64_data = base64.b64encode(f.read())
    return str(base64_data, 'utf-8')


""" 你的 APPID AK SK """
APP_ID = '17089347'
API_KEY = 'is7bz1KzapTwT78HoTY0hn1t'
SECRET_KEY = 'qk4kiMy3gg796QO8n6dEaLoI8Ud2XuLY'
groupIdList = "TEAM_GO"
client = AipFace(APP_ID, API_KEY, SECRET_KEY)

url = sys.argv[1]
# url = "C://Users/HP-PC/Pictures/1.png"

image = tobase64(url)
imageType = "BASE64"

options = {}
options["max_face_num"] = 1

""" 带参数调用人脸搜索 """
res = client.search(image, imageType, groupIdList, options)
res = res["result"]["user_list"][0]
face_id = res["user_id"]
score = res["score"]


print(face_id)
print(score)
