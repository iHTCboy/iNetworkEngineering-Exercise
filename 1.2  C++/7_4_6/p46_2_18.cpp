/*
������������������������
˵����
���������������::��ʹ�á�
������������������������
*/
# include <iostream>
using namespace std;
int i=15;
int main()
{
  int i;
  i=100;
  //::i=i+1;//::Ϊ�������������������ȫ�ֱ���i��ֵ�������ξֲ�������
  ::i=::i+1;
  cout<<"ȫ�ֱ���i��ֵ��"<<::i<<endl;//���ȫ�ֱ�����ֵ��
  cout<<"�ֲ�����i��ֵ:"<<i<<endl;//����ֲ�������ֵ��
  return 0;

}
/*
�����
_________________________
1:

ȫ�ֱ���i��ֵ��101
�ֲ�����i��ֵ:100

_________________________
2:

ȫ�ֱ���i��ֵ��16
�ֲ�����i��ֵ:100
_________________________
*/