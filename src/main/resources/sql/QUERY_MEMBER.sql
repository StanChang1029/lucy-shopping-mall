select * from shopping_schema.member

where available = TRUE
[ and member_email like :MEM_EMAIL ]
[ and member_phone like :MEM_PHONE ]
[ and member_name like :MEM_NAME ]
[ and seller_point between :MEM_SELLERMIN and :MEM_SELLERMAX ]
[ and buyer_point between :MEM_BUYERMIN and :MEM_BUYERMAX ]
[ and create_time between :MEM_CREATEFROM and :MEM_CREATETO ]
[ and edit_time between :MEM_EDITFROM and :MEM_EDITTO ]

 order by edit_time asc
 
--[ offset :STARTCOLUMN rows]
--[ fetch next :PAGESIZE rows only]