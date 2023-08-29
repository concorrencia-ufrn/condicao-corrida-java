import pandas as pd
import sys
 
# total arguments
n = len(sys.argv)

if(n < 1):
  print("You should inform the {option} parameter (0 or 1)")
  quit()

option =sys.argv[1]
print("Option choosed:",option)
 

if option == "0":

  df = pd.read_csv('out.csv',names=['thread','number'],sep=";")
 
  df_duplicated = df.groupby('number').size().reset_index(name='counts').query("counts > 1")

  print(df_duplicated.sort_values('counts', ascending=False) )
  
elif option == "1":

  df = pd.read_csv('out.csv',names=['number'])
 
  df_duplicated = df.groupby('number').size().reset_index(name='counts').query("counts > 1")

  print(df_duplicated.sort_values('counts', ascending=False) )


