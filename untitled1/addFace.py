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
groupId = "TEAM_GO"

client = AipFace(APP_ID, API_KEY, SECRET_KEY)

face_id = sys.argv[1]
# face_id = str(1000)
url = sys.argv[2]
# url = "H:/Asuka.jpg"

image = tobase64(url)
imageType = "BASE64"
userId = face_id

# options = {}
# options["quality_control"] = "NORMAL"
# options["liveness_control"] = "NORMAL"

res = client.addUser(image, imageType, groupId, userId)
print(res)