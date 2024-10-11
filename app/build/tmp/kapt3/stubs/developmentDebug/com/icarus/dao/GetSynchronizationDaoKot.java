package com.icarus.dao;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u00ec\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b$\bg\u0018\u00002\u00020\u0001J#\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000bH\'\u00a2\u0006\u0002\u0010\u0016J-\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000bH\'\u00a2\u0006\u0002\u0010\u001cJ\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000bH\'\u00a2\u0006\u0002\u0010 J\u0017\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u000bH\'\u00a2\u0006\u0002\u0010$J\u0017\u0010%\u001a\u00020\"2\b\u0010&\u001a\u0004\u0018\u00010\u000bH\'\u00a2\u0006\u0002\u0010$J\u0012\u0010\'\u001a\u00020\"2\b\u0010&\u001a\u0004\u0018\u00010\u001eH\'J\u0017\u0010(\u001a\u00020\"2\b\u0010&\u001a\u0004\u0018\u00010\u000bH\'\u00a2\u0006\u0002\u0010$J\u0017\u0010)\u001a\u00020\"2\b\u0010&\u001a\u0004\u0018\u00010\u000bH\'\u00a2\u0006\u0002\u0010$J\u0014\u0010*\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010\u001eH\'J,\u0010-\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u00010\u001e2\u0010\u00100\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u0003H\'J\u001f\u00101\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010.2\b\u00102\u001a\u0004\u0018\u00010\u000bH\'\u00a2\u0006\u0002\u00103J!\u00104\u001a\f\u0012\u0006\u0012\u0004\u0018\u000105\u0018\u00010\u00032\b\u00106\u001a\u0004\u0018\u00010\u000bH\'\u00a2\u0006\u0002\u00103J\u0014\u00107\u001a\u0004\u0018\u00010+2\b\u00108\u001a\u0004\u0018\u00010\u001eH\'J#\u00109\u001a\u0004\u0018\u00010:2\b\u00108\u001a\u0004\u0018\u00010\u001e2\b\u0010;\u001a\u0004\u0018\u00010\u000bH\'\u00a2\u0006\u0002\u0010<J\u0014\u0010=\u001a\u0004\u0018\u00010>2\b\u00108\u001a\u0004\u0018\u00010\u001eH\'J\u0014\u0010?\u001a\u0004\u0018\u00010@2\b\u00108\u001a\u0004\u0018\u00010\u001eH\'J#\u0010A\u001a\u0004\u0018\u00010B2\b\u00108\u001a\u0004\u0018\u00010\u001e2\b\u00106\u001a\u0004\u0018\u00010\u000bH\'\u00a2\u0006\u0002\u0010CJ\u001e\u0010D\u001a\u0004\u0018\u00010E2\b\u00108\u001a\u0004\u0018\u00010\u001e2\b\u0010F\u001a\u0004\u0018\u00010\u001eH\'J#\u0010G\u001a\u0004\u0018\u00010H2\b\u00108\u001a\u0004\u0018\u00010\u001e2\b\u0010I\u001a\u0004\u0018\u00010\u000bH\'\u00a2\u0006\u0002\u0010JJ\u0019\u0010K\u001a\u0004\u0018\u00010L2\b\u00102\u001a\u0004\u0018\u00010\u000bH\'\u00a2\u0006\u0002\u0010MJ\u0019\u0010N\u001a\u0004\u0018\u00010O2\b\u0010P\u001a\u0004\u0018\u00010\u000bH\'\u00a2\u0006\u0002\u0010QJ\u0019\u0010R\u001a\u0004\u0018\u00010S2\b\u00102\u001a\u0004\u0018\u00010\u000bH\'\u00a2\u0006\u0002\u0010TJ#\u0010U\u001a\u0004\u0018\u00010V2\b\u00108\u001a\u0004\u0018\u00010\u001e2\b\u0010I\u001a\u0004\u0018\u00010\u000bH\'\u00a2\u0006\u0002\u0010WJ\u001e\u0010X\u001a\u0004\u0018\u00010Y2\b\u00108\u001a\u0004\u0018\u00010\u001e2\b\u0010F\u001a\u0004\u0018\u00010\u001eH\'J-\u0010Z\u001a\u0004\u0018\u00010[2\b\u0010P\u001a\u0004\u0018\u00010\u000b2\b\u0010I\u001a\u0004\u0018\u00010\u000b2\b\u0010F\u001a\u0004\u0018\u00010\u001eH\'\u00a2\u0006\u0002\u0010\\J7\u0010]\u001a\u0004\u0018\u00010^2\b\u00108\u001a\u0004\u0018\u00010\u001e2\b\u0010_\u001a\u0004\u0018\u00010\u000b2\b\u0010F\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000bH\'\u00a2\u0006\u0002\u0010`JA\u0010a\u001a\u0004\u0018\u00010^2\b\u00108\u001a\u0004\u0018\u00010\u001e2\b\u0010_\u001a\u0004\u0018\u00010\u000b2\b\u0010b\u001a\u0004\u0018\u00010\u001e2\b\u0010F\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000bH\'\u00a2\u0006\u0002\u0010cJ#\u0010d\u001a\u0004\u0018\u00010e2\b\u0010F\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000bH\'\u00a2\u0006\u0002\u0010fJ-\u0010g\u001a\u0004\u0018\u00010h2\b\u00108\u001a\u0004\u0018\u00010\u001e2\b\u0010I\u001a\u0004\u0018\u00010\u000b2\b\u0010F\u001a\u0004\u0018\u00010\u001eH\'\u00a2\u0006\u0002\u0010iJ#\u0010j\u001a\u0004\u0018\u00010k2\b\u0010P\u001a\u0004\u0018\u00010\u000b2\b\u00106\u001a\u0004\u0018\u00010\u000bH\'\u00a2\u0006\u0002\u0010lJ\u0019\u0010m\u001a\u0004\u0018\u00010n2\b\u0010o\u001a\u0004\u0018\u00010\u000bH\'\u00a2\u0006\u0002\u0010pJ\u0012\u0010q\u001a\u00020r2\b\u0010s\u001a\u0004\u0018\u00010EH\'J\u0012\u0010t\u001a\u00020r2\b\u0010u\u001a\u0004\u0018\u00010HH\'J\u0012\u0010v\u001a\u00020r2\b\u0010w\u001a\u0004\u0018\u00010+H\'J\u001a\u0010x\u001a\u00020\"2\u0010\u0010y\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010+\u0018\u00010\u0003H\'J\u0012\u0010z\u001a\u00020r2\b\u0010{\u001a\u0004\u0018\u00010:H\'J\u001a\u0010|\u001a\u00020\"2\u0010\u0010}\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010:\u0018\u00010\u0003H\'J\u0012\u0010~\u001a\u00020r2\b\u0010\u007f\u001a\u0004\u0018\u00010>H\'J\u001c\u0010\u0080\u0001\u001a\u00020\"2\u0011\u0010\u0081\u0001\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010>\u0018\u00010\u0003H\'J\u0014\u0010\u0082\u0001\u001a\u00020r2\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010VH\'J\u0014\u0010\u0084\u0001\u001a\u00020r2\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010YH\'J\u0014\u0010\u0086\u0001\u001a\u00020r2\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010[H\'J\u0014\u0010\u0088\u0001\u001a\u00020r2\t\u0010\u0089\u0001\u001a\u0004\u0018\u00010@H\'J\u001c\u0010\u008a\u0001\u001a\u00020\"2\u0011\u0010\u008b\u0001\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010@\u0018\u00010\u0003H\'J\u0014\u0010\u008c\u0001\u001a\u00020r2\t\u0010\u008d\u0001\u001a\u0004\u0018\u00010^H\'J\u0014\u0010\u008e\u0001\u001a\u00020r2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010hH\'J\u0014\u0010\u0090\u0001\u001a\u00020r2\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010eH\'J\u0014\u0010\u0092\u0001\u001a\u00020r2\t\u0010\u0093\u0001\u001a\u0004\u0018\u00010BH\'J\u001c\u0010\u0094\u0001\u001a\u00020\"2\u0011\u0010\u0095\u0001\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010B\u0018\u00010\u0003H\'J3\u0010\u0096\u0001\u001a\u00020\"2\n\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0098\u00012\n\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u009a\u00012\u0010\u0010\u009b\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010\u009c\u00010\u0003H\u0017J\u0015\u0010\u009d\u0001\u001a\u00020r2\n\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009f\u0001H\'J\u0015\u0010\u00a0\u0001\u001a\u00020r2\n\u0010\u00a1\u0001\u001a\u0005\u0018\u00010\u00a2\u0001H\'J\u0015\u0010\u00a3\u0001\u001a\u00020r2\n\u0010\u00a4\u0001\u001a\u0005\u0018\u00010\u00a5\u0001H\'J\u001d\u0010\u00a6\u0001\u001a\u00020\"2\u0012\u0010\u00a7\u0001\u001a\r\u0012\u0007\u0012\u0005\u0018\u00010\u00a5\u0001\u0018\u00010\u0003H\'J\u001d\u0010\u00a8\u0001\u001a\u00020\"2\u0012\u0010\u00a9\u0001\u001a\r\u0012\u0007\u0012\u0005\u0018\u00010\u009c\u0001\u0018\u00010\u0003H\'J\u0014\u0010\u00aa\u0001\u001a\u00020r2\t\u0010\u00ab\u0001\u001a\u0004\u0018\u00010\u0013H\'J\u001d\u0010\u00ac\u0001\u001a\u00020\"2\u0012\u0010\u00ad\u0001\u001a\r\u0012\u0007\u0012\u0005\u0018\u00010\u00ae\u0001\u0018\u00010\u0003H\'J\u0015\u0010\u00af\u0001\u001a\u00020r2\n\u0010\u00b0\u0001\u001a\u0005\u0018\u00010\u00b1\u0001H\'J\u0015\u0010\u00b2\u0001\u001a\u00020r2\n\u0010\u00b3\u0001\u001a\u0005\u0018\u00010\u00b4\u0001H\'J\u0015\u0010\u00b5\u0001\u001a\u00020r2\n\u0010\u00b6\u0001\u001a\u0005\u0018\u00010\u0098\u0001H\'J\u0015\u0010\u00b7\u0001\u001a\u00020\"2\n\u0010\u00b8\u0001\u001a\u0005\u0018\u00010\u009a\u0001H\'J\u0014\u0010\u00b9\u0001\u001a\u00020r2\t\u0010\u00ba\u0001\u001a\u0004\u0018\u00010\u0004H\'J\u0015\u0010\u00bb\u0001\u001a\u00020r2\n\u0010\u00bc\u0001\u001a\u0005\u0018\u00010\u00bd\u0001H\'J\u0015\u0010\u00be\u0001\u001a\u00020\"2\n\u0010\u00bf\u0001\u001a\u0005\u0018\u00010\u00c0\u0001H\'J\u0015\u0010\u00c1\u0001\u001a\u00020r2\n\u0010\u00c2\u0001\u001a\u0005\u0018\u00010\u00c3\u0001H\'J\u0015\u0010\u00c4\u0001\u001a\u00020r2\n\u0010\u00c5\u0001\u001a\u0005\u0018\u00010\u00c6\u0001H\'J\u0015\u0010\u00c7\u0001\u001a\u00020r2\n\u0010\u00c8\u0001\u001a\u0005\u0018\u00010\u00c9\u0001H\'J\u0014\u0010\u00ca\u0001\u001a\u00020r2\t\u0010\u00cb\u0001\u001a\u0004\u0018\u00010\bH\'J\u0015\u0010\u00cc\u0001\u001a\u00020\"2\n\u0010\u00cd\u0001\u001a\u0005\u0018\u00010\u00ce\u0001H\'J\u001d\u0010\u00cf\u0001\u001a\u00020r2\b\u0010\u00d0\u0001\u001a\u00030\u00d1\u0001H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0003\u0010\u00d2\u0001J\u0015\u0010\u00d3\u0001\u001a\u00020r2\n\u0010\u00d4\u0001\u001a\u0005\u0018\u00010\u00d5\u0001H\'J\u001d\u0010\u00d3\u0001\u001a\u00020\"2\u0012\u0010\u00d4\u0001\u001a\r\u0012\u0007\u0012\u0005\u0018\u00010\u00d5\u0001\u0018\u00010\u0003H\'J\u0014\u0010\u00d6\u0001\u001a\u00020\"2\t\u0010\u00d7\u0001\u001a\u0004\u0018\u00010LH\'J\u0015\u0010\u00d8\u0001\u001a\u00020r2\n\u0010\u00d9\u0001\u001a\u0005\u0018\u00010\u00da\u0001H\'J\u001d\u0010\u00db\u0001\u001a\u00020\"2\u0012\u0010\u00d9\u0001\u001a\r\u0012\u0007\u0012\u0005\u0018\u00010\u00da\u0001\u0018\u00010\u0003H\'J\u0014\u0010\u00dc\u0001\u001a\u00020\"2\t\u0010\u00dd\u0001\u001a\u0004\u0018\u00010SH\'J\u0014\u0010\u00de\u0001\u001a\u00020\"2\t\u0010\u00df\u0001\u001a\u0004\u0018\u00010OH\'J,\u0010\u00e0\u0001\u001a\u00020\"2\r\u0010\u00e1\u0001\u001a\b\u0012\u0004\u0012\u00020O0\u00032\u0012\u0010\u00e2\u0001\u001a\r\u0012\u0007\u0012\u0005\u0018\u00010\u00d5\u0001\u0018\u00010\u0003H\u0017J\u0015\u0010\u00e3\u0001\u001a\u00020\"2\n\u0010\u00e4\u0001\u001a\u0005\u0018\u00010\u00e5\u0001H\'J\u0014\u0010\u00e6\u0001\u001a\u00020r2\t\u0010\u00e7\u0001\u001a\u0004\u0018\u00010\u0018H\'J\u0015\u0010\u00e8\u0001\u001a\u00020\"2\n\u0010\u00cd\u0001\u001a\u0005\u0018\u00010\u00e9\u0001H\'J\u0014\u0010\u00ea\u0001\u001a\u00020r2\t\u0010\u00eb\u0001\u001a\u0004\u0018\u00010\u0010H\'J\u0015\u0010\u00ec\u0001\u001a\u00020\"2\n\u0010\u00ed\u0001\u001a\u0005\u0018\u00010\u00ee\u0001H\'J\u0015\u0010\u00ef\u0001\u001a\u00020\"2\n\u0010\u00f0\u0001\u001a\u0005\u0018\u00010\u00f1\u0001H\'J\u0015\u0010\u00f2\u0001\u001a\u00020\"2\n\u0010\u00f3\u0001\u001a\u0005\u0018\u00010\u00f4\u0001H\'J\u0015\u0010\u00f5\u0001\u001a\u00020\"2\n\u0010\u00f6\u0001\u001a\u0005\u0018\u00010\u00f7\u0001H\'J\u0015\u0010\u00f8\u0001\u001a\u00020r2\n\u0010\u00f9\u0001\u001a\u0005\u0018\u00010\u00fa\u0001H\'J\u0015\u0010\u00fb\u0001\u001a\u00020r2\n\u0010\u00fc\u0001\u001a\u0005\u0018\u00010\u00fd\u0001H\'J\u0015\u0010\u00fe\u0001\u001a\u00020r2\n\u0010\u00ff\u0001\u001a\u0005\u0018\u00010\u0080\u0002H\'J\u0014\u0010\u0081\u0002\u001a\u00020r2\t\u0010\u0082\u0002\u001a\u0004\u0018\u00010kH\'J\u0014\u0010\u0083\u0002\u001a\u00020\"2\t\u0010\u0084\u0002\u001a\u0004\u0018\u00010nH\'J\u001b\u0010\u0085\u0002\u001a\u00020\"2\u0010\u0010\u0086\u0002\u001a\u000b\u0012\u0005\u0012\u00030\u0087\u0002\u0018\u00010\u0003H\'J\u001b\u0010\u0088\u0002\u001a\u00020\"2\u0010\u0010\u0089\u0002\u001a\u000b\u0012\u0005\u0012\u00030\u008a\u0002\u0018\u00010\u0003H\'J\u001b\u0010\u008b\u0002\u001a\u00020\"2\u0010\u0010\u008c\u0002\u001a\u000b\u0012\u0005\u0012\u00030\u008d\u0002\u0018\u00010\u0003H\'J\u0014\u0010\u008e\u0002\u001a\u00020\"2\t\u0010\u0084\u0002\u001a\u0004\u0018\u00010nH\'J\u0015\u0010\u008f\u0002\u001a\u00020\"2\n\u0010\u0090\u0002\u001a\u0005\u0018\u00010\u0087\u0002H\'J\u001d\u0010\u008f\u0002\u001a\u00020\"2\u0012\u0010\u0090\u0002\u001a\r\u0012\u0007\u0012\u0005\u0018\u00010\u0087\u0002\u0018\u00010\u0003H\'J\u0015\u0010\u0091\u0002\u001a\u00020\"2\n\u0010\u0092\u0002\u001a\u0005\u0018\u00010\u0093\u0002H\'J\u0015\u0010\u0094\u0002\u001a\u00020\"2\n\u0010\u008c\u0002\u001a\u0005\u0018\u00010\u008d\u0002H\'J\u0015\u0010\u0095\u0002\u001a\u00020\"2\n\u0010\u0089\u0002\u001a\u0005\u0018\u00010\u008a\u0002H\'J\u0015\u0010\u0096\u0002\u001a\u00020r2\n\u0010\u0097\u0002\u001a\u0005\u0018\u00010\u0098\u0002H\'JB\u0010\u0099\u0002\u001a\u00020\"2\u0007\u0010\u0084\u0002\u001a\u00020n2\u000e\u0010\u009a\u0002\u001a\t\u0012\u0005\u0012\u00030\u008d\u00020\u00032\u000e\u0010\u009b\u0002\u001a\t\u0012\u0005\u0012\u00030\u008a\u00020\u00032\u000e\u0010\u009c\u0002\u001a\t\u0012\u0005\u0012\u00030\u0087\u00020\u0003H\u0017J\u0013\u0010\u009d\u0002\u001a\u00020\"2\b\u00108\u001a\u0004\u0018\u00010\u001eH\'J\u0019\u0010\u009e\u0002\u001a\u00020\"2\t\u0010\u009f\u0002\u001a\u0004\u0018\u00010\u000bH\'\u00a2\u0006\u0002\u0010$J\u0019\u0010\u00a0\u0002\u001a\u00020\"2\t\u0010\u009f\u0002\u001a\u0004\u0018\u00010\u000bH\'\u00a2\u0006\u0002\u0010$J%\u0010\u00a1\u0002\u001a\u00020\"2\t\u0010\u00a2\u0002\u001a\u0004\u0018\u00010\u000b2\t\u0010\u00a3\u0002\u001a\u0004\u0018\u00010\u000bH\'\u00a2\u0006\u0003\u0010\u00a4\u0002J\u0013\u0010\u00a5\u0002\u001a\u00020\"2\b\u00108\u001a\u0004\u0018\u00010\u001eH\'J\u0014\u0010\u00a6\u0002\u001a\u00020\"2\t\u0010\u00a7\u0002\u001a\u0004\u0018\u00010\u001eH\'J\u0014\u0010\u00a8\u0002\u001a\u00020\"2\t\u0010\u00a9\u0002\u001a\u0004\u0018\u00010\u001eH\'J\u0014\u0010\u00aa\u0002\u001a\u00020\"2\t\u0010\u00ab\u0002\u001a\u0004\u0018\u00010\u001eH\'J\u0014\u0010\u00ac\u0002\u001a\u00020\"2\t\u0010\u00a9\u0002\u001a\u0004\u0018\u00010\u001eH\'J\u0013\u0010\u00ad\u0002\u001a\u00020\"2\b\u00108\u001a\u0004\u0018\u00010\u001eH\'J\u0014\u0010\u00ae\u0002\u001a\u00020\"2\t\u0010\u0084\u0002\u001a\u0004\u0018\u00010nH\'J\u001b\u0010\u00af\u0002\u001a\u00020\"2\u0010\u0010\u0086\u0002\u001a\u000b\u0012\u0005\u0012\u00030\u0087\u0002\u0018\u00010\u0003H\'J\u001b\u0010\u00b0\u0002\u001a\u00020\"2\u0010\u0010\u0089\u0002\u001a\u000b\u0012\u0005\u0012\u00030\u008a\u0002\u0018\u00010\u0003H\'J\u001b\u0010\u00b1\u0002\u001a\u00020\"2\u0010\u0010\u00b2\u0002\u001a\u000b\u0012\u0005\u0012\u00030\u008d\u0002\u0018\u00010\u0003H\'J\u0018\u0010\u00b3\u0002\u001a\u00020\"2\b\u0010P\u001a\u0004\u0018\u00010\u000bH\'\u00a2\u0006\u0002\u0010$J\u0016\u0010\u00b4\u0002\u001a\u0004\u0018\u00010n2\t\u0010\u00b5\u0002\u001a\u0004\u0018\u00010\u001eH\'J\u0017\u0010\u00b6\u0002\u001a\u0005\u0018\u00010\u0087\u00022\t\u0010\u00b7\u0002\u001a\u0004\u0018\u00010\u001eH\'J\u0017\u0010\u00b8\u0002\u001a\u0005\u0018\u00010\u008d\u00022\t\u0010\u00b9\u0002\u001a\u0004\u0018\u00010\u001eH\'J\u0017\u0010\u00ba\u0002\u001a\u0005\u0018\u00010\u008a\u00022\t\u0010\u00bb\u0002\u001a\u0004\u0018\u00010\u001eH\'R\u001e\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038gX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00038gX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00038gX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\u0006R\u001e\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u00038gX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u0006R\u001e\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u00038gX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u00bc\u0002"}, d2 = {"Lcom/icarus/dao/GetSynchronizationDaoKot;", "", "clientLogo", "", "Lcom/icarus/entities/ClientLogoEntity;", "getClientLogo", "()Ljava/util/List;", "hazards", "Lcom/icarus/entities/HazardsEntity;", "getHazards", "latestWorkorders", "", "getLatestWorkorders", "nonSyncedChecklists", "getNonSyncedChecklists", "ppes", "Lcom/icarus/entities/PepesEntity;", "getPpes", "checkIfChecklistPpesExists", "Lcom/icarus/entities/CheckListPpesEntity;", "stepId", "ppeId", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/icarus/entities/CheckListPpesEntity;", "checkIfNcwHazardsExists", "Lcom/icarus/entities/NcwHazardsEntity;", "itemTypeId", "itemId", "hazardId", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/icarus/entities/NcwHazardsEntity;", "customFieldType", "", "stepAttributeId", "(Ljava/lang/Integer;)Ljava/lang/String;", "deleteQRStorage", "", "qrStorageID", "(Ljava/lang/Integer;)V", "deleteSyncedWorkorder", "oldId", "deleteSyncedWorkorderAttachment", "deleteSyncedWorkorderNote", "deleteSyncedWorkorderNoteDetail", "getAssignedChecklist", "Lcom/icarus/entities/AssignCheckListEntity;", "checklistUuid", "getLatestAssignedChecklists", "", "modified", "status", "getLatestChecklists", "locationId", "(Ljava/lang/Integer;)Ljava/util/List;", "getResourcesToDownload", "Lcom/icarus/models/ResourceDownloadItems;", "userId", "ifAssignedChecklistExists", "uuid", "ifAssignedDepartmentExists", "Lcom/icarus/entities/AsssignedDepartmentsEntity;", "depId", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/icarus/entities/AsssignedDepartmentsEntity;", "ifAssignedLogoExists", "Lcom/icarus/entities/AssignedLogoEntity;", "ifAssignedRoomEquipmentExists", "Lcom/icarus/entities/AssignRoomEquipmentsEntity;", "ifAssignedUserExists", "Lcom/icarus/entities/AssignedUserEntity;", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/icarus/entities/AssignedUserEntity;", "ifCommentExists", "Lcom/icarus/entities/AssignedChecklistCommentsEntity;", "assignedChecklistUuid", "ifDecisionExists", "Lcom/icarus/entities/AssignedDecisionEntity;", "checkListElementID", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/icarus/entities/AssignedDecisionEntity;", "ifLocationEquipmentExists", "Lcom/icarus/entities/LocationEquipmentsEntity;", "(Ljava/lang/Integer;)Lcom/icarus/entities/LocationEquipmentsEntity;", "ifLocationExists", "Lcom/icarus/entities/LocationEntity;", "id", "(Ljava/lang/Integer;)Lcom/icarus/entities/LocationEntity;", "ifLocationRoomExists", "Lcom/icarus/entities/LocationRoomEntity;", "(Ljava/lang/Integer;)Lcom/icarus/entities/LocationRoomEntity;", "ifNCWExists", "Lcom/icarus/entities/AssignedNCWEntity;", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/icarus/entities/AssignedNCWEntity;", "ifPauseTimeExists", "Lcom/icarus/entities/AssignedCheckListPauseTimesEntity;", "ifPlaceholderExists", "Lcom/icarus/entities/AssignedItemPlaceholderEntity;", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/icarus/entities/AssignedItemPlaceholderEntity;", "ifStepAttributeExists", "Lcom/icarus/entities/AssignedStepAttributesEntity;", "elementId", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)Lcom/icarus/entities/AssignedStepAttributesEntity;", "ifStepAttributeWithFileExists", "value", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/icarus/entities/AssignedStepAttributesEntity;", "ifStepExists", "Lcom/icarus/entities/AssignedStepEntity;", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/icarus/entities/AssignedStepEntity;", "ifStepResourceExists", "Lcom/icarus/entities/AssignedStepFileResourceEntity;", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/icarus/entities/AssignedStepFileResourceEntity;", "ifUserFavoriteExists", "Lcom/icarus/entities/UserFavouritesEntity;", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/icarus/entities/UserFavouritesEntity;", "ifWorkOrderExists", "Lcom/icarus/entities/WorkOrderEntity;", "workOrderId", "(Ljava/lang/Integer;)Lcom/icarus/entities/WorkOrderEntity;", "insertAssigneComments", "", "assignedChecklistCommentsEntity", "insertAssigneDecision", "assignedDecisionEntity", "insertAssignedChecklists", "assignCheckListEntity", "insertAssignedChecklistsList", "assignCheckListEntityList", "insertAssignedDepartment", "asssignedDepartmentsEntity", "insertAssignedDepartmentList", "asssignedDepartmentsEntityList", "insertAssignedLogoEntity", "assignedLogoEntity", "insertAssignedLogoEntityList", "assignedLogoEntityList", "insertAssignedNCW", "assignedNCWEntity", "insertAssignedPauseTime", "assignedCheckListPauseTimesEntity", "insertAssignedPlaceholder", "assignedItemPlaceholderEntity", "insertAssignedRoomEquipmentEntity", "assignRoomEquipmentsEntity", "insertAssignedRoomEquipmentEntityList", "assignRoomEquipmentsEntityList", "insertAssignedStepAttribute", "assignedStepAttributesEntity", "insertAssignedStepResources", "assignedStepFleResourceEntity", "insertAssignedSteps", "assignedStepEntity", "insertAssignedUsers", "assignedUserEntity", "insertAssignedUsersList", "assignedUserEntityList", "insertChecklistAssociatedData", "checklist", "Lcom/icarus/entities/AllChecklistEntity;", "checklistTitle", "Lcom/icarus/entities/CheckListTitlesEntity;", "checklistLogos", "Lcom/icarus/entities/CheckListLogoEntity;", "insertChecklistElements", "checklistElementsEntity", "Lcom/icarus/entities/ChecklistElementsEntity;", "insertChecklistExecutionPermissions", "checklistExecutionPermission", "Lcom/icarus/entities/ChecklistExecutionPermission;", "insertChecklistLocation", "checklistLocationEntity", "Lcom/icarus/entities/ChecklistLocationEntity;", "insertChecklistLocationList", "checklistLocationEntityList", "insertChecklistLogo", "mapChecklistLogo", "insertChecklistPeps", "checkListPpesEntity", "insertChecklistRoomEquipments", "mapRoomEquipment", "Lcom/icarus/entities/ChecklistRoomEquipmentsEntity;", "insertChecklistStatuses", "checklistStatusEntity", "Lcom/icarus/entities/ChecklistStatusEntity;", "insertChecklistType", "checklistTypeEntity", "Lcom/icarus/entities/ChecklistTypeEntity;", "insertChecklists", "allChecklistEntity", "insertChecklistsTitle", "mapChecklistTitleEntity", "insertClientLogo", "clientLogoEntity", "insertClientSetting", "clientSettingEntity", "Lcom/icarus/entities/ClientSettingEntity;", "insertCustomFields", "mapCustomField", "Lcom/icarus/entities/CustomFieldsEntity;", "insertDepartments", "departmentsEntity", "Lcom/icarus/entities/DepartmentsEntity;", "insertEquipments", "equipmentsEntity", "Lcom/icarus/entities/EquipmentsEntity;", "insertGroups", "groupEntity", "Lcom/icarus/entities/GroupEntity;", "insertHazards", "hazardsEntity", "insertItemPlaceholder", "mapPlaceholder", "Lcom/icarus/entities/ItemPlaceholdersEntity;", "insertItemType", "itemTypeEntity", "Lcom/icarus/entities/ItemTypeEntity;", "(Lcom/icarus/entities/ItemTypeEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertLocationDepartments", "locationDepartmentsEntity", "Lcom/icarus/entities/LocationDepartmentsEntity;", "insertLocationEquipment", "locationEquipmentsEntity", "insertLocationEquipments", "locationRoomEquipmentsEntity", "Lcom/icarus/entities/LocationRoomEquipmentsEntity;", "insertLocationRoomEquipments", "insertLocationRooms", "locationRoomEntity", "insertLocations", "locationEntity", "insertLocationsWithAssociatedData", "locationEntities", "locationDepartmentsEntities", "insertLogs", "mapLogs", "Lcom/icarus/entities/LogsEntity;", "insertNCWHazards", "ncwHazardsEntity", "insertPlaceholder", "Lcom/icarus/entities/PlaceholderEntity;", "insertPpes", "pepesEntity", "insertQRStorage", "qrStorageEntity", "Lcom/icarus/entities/QRStorageEntity;", "insertReferanceLinks", "mapReferanceLinks", "Lcom/icarus/entities/ResourcesLinksEntity;", "insertReferances", "mapReferances", "Lcom/icarus/entities/ResourceEntity;", "insertRoomEntity", "mapRoomsEntity", "Lcom/icarus/entities/RoomsEntity;", "insertStepAttributes", "stepAttributesEntity", "Lcom/icarus/entities/StepAttributesEntity;", "insertUserDepartments", "userLocationsDepartments", "Lcom/icarus/entities/UserLocationsDepartments;", "insertUserEntity", "usersEntity", "Lcom/icarus/entities/UsersEntity;", "insertUserFavouriteEntity", "userFavouritesEntity", "insertWorkOrder", "workOrderEntity", "insertWorkOrderAttachments", "workOrderAttachmentEntity", "Lcom/icarus/entities/WorkOrderAttachmentsEntity;", "insertWorkOrderNoteDetails", "workOrderNoteDetailEntity", "Lcom/icarus/entities/WorkOrderNoteDetailEntity;", "insertWorkOrderNotes", "workOrderNotesEntity", "Lcom/icarus/entities/WorkOrderNotesEntity;", "insertWorkorder", "insertWorkorderAttachment", "workOrderAttachmentsEntity", "insertWorkorderBillingType", "mapWorkOrderBillingTypeEntity", "Lcom/icarus/entities/WorkOrderBillingTypeEntity;", "insertWorkorderNote", "insertWorkorderNoteDetail", "insertWorkorderStatus", "workOrdeStatusEntity", "Lcom/icarus/entities/WorkOrdeStatusEntity;", "saveWorkOrder", "workOrderNoteEntities", "workOrderNoteDetailEntities", "workOrderAttachmentEntities", "updateAssignedChecklistSyncStatus", "updateChecklistPendingReferenceCount", "checklistId", "updateChecklistPendingResourceCount", "updateChecklistSyncStatus", "checklistID", "syncStatus", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "updateClientLogo", "updateReferenceChecklistStatus", "referencesChecksum", "updateReferenceSyncStatus", "checksum", "updateResourceChecklistStatus", "resourceChecksum", "updateResourceSyncStatus", "updateResources", "updateWorkOrder", "updateWorkOrderAttachments", "updateWorkOrderNoteDetails", "updateWorkOrderNotes", "workOrderNotesEntities", "updateWorkorderExecutionStatus", "workOrder", "workOrderUuid", "workOrderAttachment", "workOrderAttachmentUuid", "workOrderNote", "workOrderNoteUuid", "workOrderNoteDetail", "workOrderNoteDetailUuid", "app_developmentDebug"})
@androidx.room.Dao
public abstract interface GetSynchronizationDaoKot {
    
    @androidx.room.Insert(onConflict = 1)
    public abstract long insertChecklistStatuses(@org.jetbrains.annotations.Nullable
    com.icarus.entities.ChecklistStatusEntity checklistStatusEntity);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract long insertDepartments(@org.jetbrains.annotations.Nullable
    com.icarus.entities.DepartmentsEntity departmentsEntity);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract long insertChecklistType(@org.jetbrains.annotations.Nullable
    com.icarus.entities.ChecklistTypeEntity checklistTypeEntity);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract long insertClientSetting(@org.jetbrains.annotations.Nullable
    com.icarus.entities.ClientSettingEntity clientSettingEntity);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertItemType(@org.jetbrains.annotations.NotNull
    com.icarus.entities.ItemTypeEntity itemTypeEntity, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract long insertPpes(@org.jetbrains.annotations.Nullable
    com.icarus.entities.PepesEntity pepesEntity);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract long insertChecklistExecutionPermissions(@org.jetbrains.annotations.Nullable
    com.icarus.entities.ChecklistExecutionPermission checklistExecutionPermission);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract long insertWorkorderStatus(@org.jetbrains.annotations.Nullable
    com.icarus.entities.WorkOrdeStatusEntity workOrdeStatusEntity);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract long insertChecklists(@org.jetbrains.annotations.Nullable
    com.icarus.entities.AllChecklistEntity allChecklistEntity);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract long insertEquipments(@org.jetbrains.annotations.Nullable
    com.icarus.entities.EquipmentsEntity equipmentsEntity);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract long insertGroups(@org.jetbrains.annotations.Nullable
    com.icarus.entities.GroupEntity groupEntity);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract long insertHazards(@org.jetbrains.annotations.Nullable
    com.icarus.entities.HazardsEntity hazardsEntity);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract long insertLocationEquipments(@org.jetbrains.annotations.Nullable
    com.icarus.entities.LocationRoomEquipmentsEntity locationRoomEquipmentsEntity);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract void insertLocationRoomEquipments(@org.jetbrains.annotations.Nullable
    java.util.List<? extends com.icarus.entities.LocationRoomEquipmentsEntity> locationRoomEquipmentsEntity);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract long insertLocationDepartments(@org.jetbrains.annotations.Nullable
    com.icarus.entities.LocationDepartmentsEntity locationDepartmentsEntity);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract void insertLocationDepartments(@org.jetbrains.annotations.Nullable
    java.util.List<? extends com.icarus.entities.LocationDepartmentsEntity> locationDepartmentsEntity);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract void insertLocations(@org.jetbrains.annotations.Nullable
    com.icarus.entities.LocationEntity locationEntity);
    
    @androidx.room.Query(value = "SELECT * FROM locations WHERE id = :id")
    @org.jetbrains.annotations.Nullable
    public abstract com.icarus.entities.LocationEntity ifLocationExists(@org.jetbrains.annotations.Nullable
    java.lang.Integer id);
    
    @androidx.room.Transaction
    public abstract void insertLocationsWithAssociatedData(@org.jetbrains.annotations.NotNull
    java.util.List<? extends com.icarus.entities.LocationEntity> locationEntities, @org.jetbrains.annotations.Nullable
    java.util.List<? extends com.icarus.entities.LocationDepartmentsEntity> locationDepartmentsEntities);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract long insertUserEntity(@org.jetbrains.annotations.Nullable
    com.icarus.entities.UsersEntity usersEntity);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract long insertUserDepartments(@org.jetbrains.annotations.Nullable
    com.icarus.entities.UserLocationsDepartments userLocationsDepartments);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract long insertUserFavouriteEntity(@org.jetbrains.annotations.Nullable
    com.icarus.entities.UserFavouritesEntity userFavouritesEntity);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract long insertClientLogo(@org.jetbrains.annotations.Nullable
    com.icarus.entities.ClientLogoEntity clientLogoEntity);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract long insertChecklistLocation(@org.jetbrains.annotations.Nullable
    com.icarus.entities.ChecklistLocationEntity checklistLocationEntity);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract void insertChecklistLocationList(@org.jetbrains.annotations.Nullable
    java.util.List<? extends com.icarus.entities.ChecklistLocationEntity> checklistLocationEntityList);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract long insertChecklistElements(@org.jetbrains.annotations.Nullable
    com.icarus.entities.ChecklistElementsEntity checklistElementsEntity);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract long insertStepAttributes(@org.jetbrains.annotations.Nullable
    com.icarus.entities.StepAttributesEntity stepAttributesEntity);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract long insertNCWHazards(@org.jetbrains.annotations.Nullable
    com.icarus.entities.NcwHazardsEntity ncwHazardsEntity);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract long insertChecklistPeps(@org.jetbrains.annotations.Nullable
    com.icarus.entities.CheckListPpesEntity checkListPpesEntity);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract long insertAssignedChecklists(@org.jetbrains.annotations.Nullable
    com.icarus.entities.AssignCheckListEntity assignCheckListEntity);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract void insertAssignedChecklistsList(@org.jetbrains.annotations.Nullable
    java.util.List<? extends com.icarus.entities.AssignCheckListEntity> assignCheckListEntityList);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract long insertAssignedLogoEntity(@org.jetbrains.annotations.Nullable
    com.icarus.entities.AssignedLogoEntity assignedLogoEntity);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract void insertAssignedLogoEntityList(@org.jetbrains.annotations.Nullable
    java.util.List<? extends com.icarus.entities.AssignedLogoEntity> assignedLogoEntityList);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract long insertAssignedRoomEquipmentEntity(@org.jetbrains.annotations.Nullable
    com.icarus.entities.AssignRoomEquipmentsEntity assignRoomEquipmentsEntity);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract void insertAssignedRoomEquipmentEntityList(@org.jetbrains.annotations.Nullable
    java.util.List<? extends com.icarus.entities.AssignRoomEquipmentsEntity> assignRoomEquipmentsEntityList);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract long insertAssignedNCW(@org.jetbrains.annotations.Nullable
    com.icarus.entities.AssignedNCWEntity assignedNCWEntity);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract long insertAssigneComments(@org.jetbrains.annotations.Nullable
    com.icarus.entities.AssignedChecklistCommentsEntity assignedChecklistCommentsEntity);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract long insertAssignedPauseTime(@org.jetbrains.annotations.Nullable
    com.icarus.entities.AssignedCheckListPauseTimesEntity assignedCheckListPauseTimesEntity);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract long insertAssigneDecision(@org.jetbrains.annotations.Nullable
    com.icarus.entities.AssignedDecisionEntity assignedDecisionEntity);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract long insertAssignedDepartment(@org.jetbrains.annotations.Nullable
    com.icarus.entities.AsssignedDepartmentsEntity asssignedDepartmentsEntity);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract void insertAssignedDepartmentList(@org.jetbrains.annotations.Nullable
    java.util.List<? extends com.icarus.entities.AsssignedDepartmentsEntity> asssignedDepartmentsEntityList);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract long insertAssignedPlaceholder(@org.jetbrains.annotations.Nullable
    com.icarus.entities.AssignedItemPlaceholderEntity assignedItemPlaceholderEntity);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract long insertAssignedStepAttribute(@org.jetbrains.annotations.Nullable
    com.icarus.entities.AssignedStepAttributesEntity assignedStepAttributesEntity);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract long insertAssignedStepResources(@org.jetbrains.annotations.Nullable
    com.icarus.entities.AssignedStepFileResourceEntity assignedStepFleResourceEntity);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract long insertAssignedSteps(@org.jetbrains.annotations.Nullable
    com.icarus.entities.AssignedStepEntity assignedStepEntity);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract long insertAssignedUsers(@org.jetbrains.annotations.Nullable
    com.icarus.entities.AssignedUserEntity assignedUserEntity);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract void insertAssignedUsersList(@org.jetbrains.annotations.Nullable
    java.util.List<? extends com.icarus.entities.AssignedUserEntity> assignedUserEntityList);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract void insertRoomEntity(@org.jetbrains.annotations.Nullable
    com.icarus.entities.RoomsEntity mapRoomsEntity);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract void insertLogs(@org.jetbrains.annotations.Nullable
    com.icarus.entities.LogsEntity mapLogs);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract void insertReferanceLinks(@org.jetbrains.annotations.Nullable
    com.icarus.entities.ResourcesLinksEntity mapReferanceLinks);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract void insertItemPlaceholder(@org.jetbrains.annotations.Nullable
    com.icarus.entities.ItemPlaceholdersEntity mapPlaceholder);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract void insertPlaceholder(@org.jetbrains.annotations.Nullable
    com.icarus.entities.PlaceholderEntity mapPlaceholder);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract void insertReferances(@org.jetbrains.annotations.Nullable
    com.icarus.entities.ResourceEntity mapReferances);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract void insertChecklistLogo(@org.jetbrains.annotations.Nullable
    java.util.List<? extends com.icarus.entities.CheckListLogoEntity> mapChecklistLogo);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract void insertChecklistRoomEquipments(@org.jetbrains.annotations.Nullable
    java.util.List<? extends com.icarus.entities.ChecklistRoomEquipmentsEntity> mapRoomEquipment);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract void insertChecklistsTitle(@org.jetbrains.annotations.Nullable
    com.icarus.entities.CheckListTitlesEntity mapChecklistTitleEntity);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract void insertCustomFields(@org.jetbrains.annotations.Nullable
    com.icarus.entities.CustomFieldsEntity mapCustomField);
    
    @androidx.room.Query(value = "SELECT DISTINCT\n   Checklist.id \n FROM checklists AS Checklist\n   INNER JOIN checklist_statuses AS ChecklistStatus ON ( ChecklistStatus.id = Checklist.checklist_status_id )\n   INNER JOIN checklist_types AS ChecklistType ON ( ChecklistType.id = Checklist.checklist_type_id )\n   LEFT JOIN checklists AS NextChecklist ON ( Checklist.id = NextChecklist.parent_id )\n   LEFT JOIN checklist_statuses AS NextChecklistStatus ON ( NextChecklistStatus.id = NextChecklist.checklist_status_id )\n   LEFT JOIN checklist_locations AS ChecklistLocation ON (ChecklistLocation.checklist_id = Checklist.id  AND ChecklistLocation.is_deleted = 0) \n WHERE\n   Checklist.is_deleted = 0 \n   AND Checklist.is_template = 0 \n   AND ChecklistStatus.is_closed = 1 \n   AND ChecklistLocation.location_id = :locationId \n   AND (NextChecklist.modified = (SELECT max(modified) FROM checklists WHERE parent_id = Checklist.id) OR NextChecklist.modified IS NULL) \n   AND (NextChecklistStatus.is_closed = 0 OR NextChecklistStatus.is_closed IS NULL)  AND Checklist.sync_status = 2  UNION SELECT AssignedChecklist.checklist_id  FROM assigned_checklists AS AssignedChecklist      LEFT JOIN checklists AS Checklist ON (Checklist.id = AssignedChecklist.checklist_id)    WHERE AssignedChecklist.checklist_status IN ( 0, 4 )  AND AssignedChecklist.is_deleted = 0 \n   AND AssignedChecklist.location_id = :locationId AND Checklist.sync_status = 2.")
    @org.jetbrains.annotations.Nullable
    public abstract java.util.List<java.lang.Integer> getLatestChecklists(@org.jetbrains.annotations.Nullable
    java.lang.Integer locationId);
    
    @androidx.room.Query(value = "select uuid from assigned_checklists where assigned_checklists.checklist_status IN (:status) and modified > :modified and execution_status = -1")
    @org.jetbrains.annotations.Nullable
    public abstract java.util.List<java.lang.String> getLatestAssignedChecklists(@org.jetbrains.annotations.Nullable
    java.lang.String modified, @org.jetbrains.annotations.Nullable
    java.util.List<java.lang.Integer> status);
    
    @androidx.room.Query(value = "select id from workorders where execution_status = -1")
    @org.jetbrains.annotations.Nullable
    public abstract java.util.List<java.lang.Integer> getLatestWorkorders();
    
    @androidx.room.Query(value = "select * from hazards")
    @org.jetbrains.annotations.Nullable
    public abstract java.util.List<com.icarus.entities.HazardsEntity> getHazards();
    
    @androidx.room.Query(value = "select * from ppes")
    @org.jetbrains.annotations.Nullable
    public abstract java.util.List<com.icarus.entities.PepesEntity> getPpes();
    
    @androidx.room.Insert(onConflict = 5)
    public abstract void insertWorkorderBillingType(@org.jetbrains.annotations.Nullable
    com.icarus.entities.WorkOrderBillingTypeEntity mapWorkOrderBillingTypeEntity);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract void insertWorkorder(@org.jetbrains.annotations.Nullable
    com.icarus.entities.WorkOrderEntity workOrderEntity);
    
    @androidx.room.Insert
    public abstract void insertWorkOrder(@org.jetbrains.annotations.Nullable
    com.icarus.entities.WorkOrderEntity workOrderEntity);
    
    @androidx.room.Update
    public abstract void updateWorkOrder(@org.jetbrains.annotations.Nullable
    com.icarus.entities.WorkOrderEntity workOrderEntity);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract void insertWorkorderAttachment(@org.jetbrains.annotations.Nullable
    com.icarus.entities.WorkOrderAttachmentsEntity workOrderAttachmentsEntity);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract void insertWorkorderAttachment(@org.jetbrains.annotations.Nullable
    java.util.List<? extends com.icarus.entities.WorkOrderAttachmentsEntity> workOrderAttachmentsEntity);
    
    @androidx.room.Insert
    public abstract void insertWorkOrderAttachments(@org.jetbrains.annotations.Nullable
    java.util.List<? extends com.icarus.entities.WorkOrderAttachmentsEntity> workOrderAttachmentEntity);
    
    @androidx.room.Update
    public abstract void updateWorkOrderAttachments(@org.jetbrains.annotations.Nullable
    java.util.List<? extends com.icarus.entities.WorkOrderAttachmentsEntity> workOrderAttachmentEntity);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract void insertWorkorderNote(@org.jetbrains.annotations.Nullable
    com.icarus.entities.WorkOrderNotesEntity workOrderNotesEntity);
    
    @androidx.room.Insert
    public abstract void insertWorkOrderNotes(@org.jetbrains.annotations.Nullable
    java.util.List<? extends com.icarus.entities.WorkOrderNotesEntity> workOrderNotesEntity);
    
    @androidx.room.Update
    public abstract void updateWorkOrderNotes(@org.jetbrains.annotations.Nullable
    java.util.List<? extends com.icarus.entities.WorkOrderNotesEntity> workOrderNotesEntities);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract void insertWorkorderNoteDetail(@org.jetbrains.annotations.Nullable
    com.icarus.entities.WorkOrderNoteDetailEntity workOrderNoteDetailEntity);
    
    @androidx.room.Insert
    public abstract void insertWorkOrderNoteDetails(@org.jetbrains.annotations.Nullable
    java.util.List<? extends com.icarus.entities.WorkOrderNoteDetailEntity> workOrderNoteDetailEntity);
    
    @androidx.room.Update
    public abstract void updateWorkOrderNoteDetails(@org.jetbrains.annotations.Nullable
    java.util.List<? extends com.icarus.entities.WorkOrderNoteDetailEntity> workOrderNoteDetailEntity);
    
    @androidx.room.Query(value = "select * from client_logos where is_downloaded = 0")
    @org.jetbrains.annotations.Nullable
    public abstract java.util.List<com.icarus.entities.ClientLogoEntity> getClientLogo();
    
    @androidx.room.Query(value = "SELECT\n   \tResource.id,\n   \tResource.uuid,\n   \tResource.file_md5_checksum,\n   \tResource.file_name,\n   \tResource.is_deleted,\n   \tResource.is_resource,\n   \tGROUP_CONCAT(DISTINCT Checklist.id) AS checklist_ids\n FROM\n   \tresources AS Resource\n \tLEFT JOIN checklist_elements AS ChecklistElement ON ((ChecklistElement.item_id = Resource.id AND ChecklistElement.item_type_id = 10 AND Resource.is_resource = 1 ) OR (ChecklistElement.item_id = Resource.item_id AND ChecklistElement.item_type_id = Resource.item_type_id AND Resource.is_resource = 0 ) )\n \tLEFT JOIN checklists AS Checklist ON ( Checklist.id = ChecklistElement.checklist_id )\n \tLEFT JOIN user_favorites AS UserFavorite ON (UserFavorite.checklist_id = Checklist.id AND UserFavorite.user_id = :userId AND UserFavorite.is_deleted = 0 ) \n \n WHERE\n   \tResource.is_deleted = 0\n   \tAND Resource.is_downloaded = 0\n   \tAND ChecklistElement.is_deleted = 0\n   \tAND (\n   \tResource.is_resource = 1 \n   \tOR (\n   \tResource.is_resource = 0 \n   \tAND ifnull(UserFavorite.is_deleted, 1) = 0 \n   \t) \n   \t)\nGROUP BY Resource.id")
    @org.jetbrains.annotations.Nullable
    public abstract java.util.List<com.icarus.models.ResourceDownloadItems> getResourcesToDownload(@org.jetbrains.annotations.Nullable
    java.lang.Integer userId);
    
    @androidx.room.Query(value = "update resources set is_downloaded = 1 where uuid = :uuid")
    public abstract void updateResources(@org.jetbrains.annotations.Nullable
    java.lang.String uuid);
    
    @androidx.room.Query(value = "update client_logos set is_downloaded = 1 where uuid = :uuid")
    public abstract void updateClientLogo(@org.jetbrains.annotations.Nullable
    java.lang.String uuid);
    
    @androidx.room.Query(value = "update checklists set sync_status = :syncStatus where id = :checklistID")
    public abstract void updateChecklistSyncStatus(@org.jetbrains.annotations.Nullable
    java.lang.Integer checklistID, @org.jetbrains.annotations.Nullable
    java.lang.Integer syncStatus);
    
    @androidx.room.Query(value = "update assigned_checklists set execution_status = 1 where uuid = :uuid")
    public abstract void updateAssignedChecklistSyncStatus(@org.jetbrains.annotations.Nullable
    java.lang.String uuid);
    
    @androidx.room.Query(value = "UPDATE checklists\nSET pending_resources_count = pending_resources_count - (\n\tSELECT COUNT(DISTINCT resources.file_md5_checksum)\n\tFROM resources\n\tLEFT JOIN checklist_elements ON (resources.id = checklist_elements.item_id AND checklist_elements.item_type_id = 10)\n\tWHERE\n\t\tchecklist_elements.is_deleted = 0\n\t\tAND resources.is_deleted = 0\n\t\tAND resources.is_resource = 1\n\t\tAND resources.is_downloaded = 1\n\t\tAND resources.file_md5_checksum = :checksum\n)\nWHERE\n\tchecklists.id IN (\n\t\tSELECT DISTINCT checklist_elements.checklist_id\n\t\tFROM checklist_elements\n\t\tLEFT JOIN resources ON (checklist_elements.item_id = resources.id AND checklist_elements.item_type_id = 10)\n\t\tWHERE\n\t\t\tchecklist_elements.is_deleted = 0\n\t\t\tAND resources.is_deleted = 0\n\t\t\tAND resources.is_resource = 1\n\t\t\tAND resources.is_downloaded = 1\n\t\t\tAND resources.file_md5_checksum = :checksum\n\t)\n\tAND checklists.pending_resources_count > 0")
    public abstract void updateResourceSyncStatus(@org.jetbrains.annotations.Nullable
    java.lang.String checksum);
    
    @androidx.room.Query(value = "UPDATE checklists\nSET pending_references_count = pending_references_count - (\n\tSELECT COUNT(DISTINCT resources.file_md5_checksum)\n\tFROM resources resources\n\tLEFT JOIN checklist_elements checklist_elements ON (resources.item_id = checklist_elements.item_id AND resources.item_type_id = checklist_elements.item_type_id)\n\tWHERE\n\t\tchecklist_elements.is_deleted = 0\n\t\tAND resources.is_deleted = 0\n\t\tAND resources.is_resource = 0\n\t\tAND resources.is_downloaded = 1\n\t\tAND resources.file_md5_checksum = :checksum\n)\nWHERE\n\tchecklists.id IN (\n\t\tSELECT DISTINCT checklist_elements.checklist_id\n\t\tFROM checklist_elements\n\t\tLEFT JOIN resources ON (checklist_elements.item_id = resources.item_id AND checklist_elements.item_type_id = resources.item_type_id)\n\t\tWHERE\n\t\t\tchecklist_elements.is_deleted = 0\n\t\t\tAND resources.is_deleted = 0\n\t\t\tAND resources.is_resource = 0\n\t\t\tAND resources.is_downloaded = 1\n\t\t\tAND resources.file_md5_checksum = :checksum\n\t)\n\tAND checklists.pending_references_count > 0")
    public abstract void updateReferenceSyncStatus(@org.jetbrains.annotations.Nullable
    java.lang.String checksum);
    
    @androidx.room.Query(value = "select id from checklists where sync_status = 2")
    @org.jetbrains.annotations.Nullable
    public abstract java.util.List<java.lang.Integer> getNonSyncedChecklists();
    
    @androidx.room.Query(value = "UPDATE checklists\nSET pending_references_count = (\n  SELECT count(DISTINCT resources.file_md5_checksum) \n  FROM checklist_elements \n  LEFT JOIN resources ON (checklist_elements.item_id = resources.item_id AND checklist_elements.item_type_id = resources.item_type_id)\n  WHERE \n  checklist_elements.checklist_id = :checklistId\n  AND checklist_elements.is_deleted = 0 \n  AND resources.is_resource = 0 \n  AND resources.is_deleted = 0 \n  AND resources.is_downloaded = 0\n)\nWHERE\n\tchecklists.id = :checklistId")
    public abstract void updateChecklistPendingReferenceCount(@org.jetbrains.annotations.Nullable
    java.lang.Integer checklistId);
    
    @androidx.room.Query(value = "UPDATE checklists\nSET pending_resources_count = (\n  SELECT count(DISTINCT resources.file_md5_checksum) \n  FROM checklist_elements \n  LEFT JOIN resources ON (checklist_elements.item_id = resources.id AND checklist_elements.item_type_id = 10)\n  WHERE \n  checklist_elements.checklist_id = :checklistId\n  AND checklist_elements.is_deleted = 0 \n  AND resources.is_resource = 1\n  AND resources.is_deleted = 0 \n  AND resources.is_downloaded = 0\n)\nWHERE\n\tchecklists.id = :checklistId")
    public abstract void updateChecklistPendingResourceCount(@org.jetbrains.annotations.Nullable
    java.lang.Integer checklistId);
    
    @androidx.room.Query(value = "select * FROM checklist_ppes where ppe_id = :ppeId and step_id = :stepId")
    @org.jetbrains.annotations.Nullable
    public abstract com.icarus.entities.CheckListPpesEntity checkIfChecklistPpesExists(@org.jetbrains.annotations.Nullable
    java.lang.Integer stepId, @org.jetbrains.annotations.Nullable
    java.lang.Integer ppeId);
    
    @androidx.room.Query(value = "select * FROM ncw_hazards where item_type_id = :itemTypeId and item_id = :itemId and hazard_id = :hazardId")
    @org.jetbrains.annotations.Nullable
    public abstract com.icarus.entities.NcwHazardsEntity checkIfNcwHazardsExists(@org.jetbrains.annotations.Nullable
    java.lang.Integer itemTypeId, @org.jetbrains.annotations.Nullable
    java.lang.Integer itemId, @org.jetbrains.annotations.Nullable
    java.lang.Integer hazardId);
    
    @androidx.room.Query(value = "update workorders set execution_status = 1 where id = :id")
    public abstract void updateWorkorderExecutionStatus(@org.jetbrains.annotations.Nullable
    java.lang.Integer id);
    
    @androidx.room.Query(value = "UPDATE checklists SET pending_references_count = pending_references_count - 1 WHERE id IN ( SELECT DISTINCT ChecklistElement.checklist_id FROM resources AS Resource LEFT JOIN checklist_elements AS ChecklistElement ON ( ( ChecklistElement.item_id = Resource.id AND ChecklistElement.item_type_id = 10 AND Resource.is_resource = 1 ) OR ( ChecklistElement.item_id = Resource.item_id AND ChecklistElement.item_type_id = Resource.item_type_id AND Resource.is_resource = 0 ) ) WHERE Resource.file_md5_checksum = :referencesChecksum AND ChecklistElement.is_deleted = 0 )")
    public abstract void updateReferenceChecklistStatus(@org.jetbrains.annotations.Nullable
    java.lang.String referencesChecksum);
    
    @androidx.room.Query(value = "UPDATE checklists SET pending_resources_count = pending_resources_count - 1 WHERE id IN (SELECT DISTINCT ChecklistElement.checklist_id FROM resources AS Resource LEFT JOIN checklist_elements AS ChecklistElement ON ( ( ChecklistElement.item_id = Resource.id AND ChecklistElement.item_type_id = 10 AND Resource.is_resource = 1 ) OR ( ChecklistElement.item_id = Resource.item_id AND ChecklistElement.item_type_id = Resource.item_type_id AND Resource.is_resource = 0 ) ) WHERE Resource.file_md5_checksum = :resourceChecksum AND ChecklistElement.is_deleted = 0 )")
    public abstract void updateResourceChecklistStatus(@org.jetbrains.annotations.Nullable
    java.lang.String resourceChecksum);
    
    @androidx.room.Query(value = "SELECT \n    *\nFROM \n    assigned_checklist_pause_times\nWHERE \n    uuid = :uuid \nAND assigned_checklist_uuid = :assignedChecklistUuid")
    @org.jetbrains.annotations.Nullable
    public abstract com.icarus.entities.AssignedCheckListPauseTimesEntity ifPauseTimeExists(@org.jetbrains.annotations.Nullable
    java.lang.String uuid, @org.jetbrains.annotations.Nullable
    java.lang.String assignedChecklistUuid);
    
    @androidx.room.Query(value = "SELECT \n    *\nFROM \n    assigned_checklist_comments\nWHERE \n    uuid = :uuid \nAND assigned_checklist_uuid = :assignedChecklistUuid")
    @org.jetbrains.annotations.Nullable
    public abstract com.icarus.entities.AssignedChecklistCommentsEntity ifCommentExists(@org.jetbrains.annotations.Nullable
    java.lang.String uuid, @org.jetbrains.annotations.Nullable
    java.lang.String assignedChecklistUuid);
    
    @androidx.room.Query(value = "SELECT \n    *\nFROM \n    assigned_item_placeholders\nWHERE \n    item_placeholder_id = :id \n AND assigned_checklist_uuid = :assignedChecklistUuid  AND checklist_element_id = :checkListElementID")
    @org.jetbrains.annotations.Nullable
    public abstract com.icarus.entities.AssignedItemPlaceholderEntity ifPlaceholderExists(@org.jetbrains.annotations.Nullable
    java.lang.Integer id, @org.jetbrains.annotations.Nullable
    java.lang.Integer checkListElementID, @org.jetbrains.annotations.Nullable
    java.lang.String assignedChecklistUuid);
    
    @androidx.room.Query(value = "SELECT \n    *\nFROM \n    assigned_step_resources\nWHERE \n    uuid = :uuid \nAND assigned_checklist_uuid = :assignedChecklistUuid  AND checklist_element_id = :checkListElementID")
    @org.jetbrains.annotations.Nullable
    public abstract com.icarus.entities.AssignedStepFileResourceEntity ifStepResourceExists(@org.jetbrains.annotations.Nullable
    java.lang.String uuid, @org.jetbrains.annotations.Nullable
    java.lang.Integer checkListElementID, @org.jetbrains.annotations.Nullable
    java.lang.String assignedChecklistUuid);
    
    @androidx.room.Query(value = "SELECT    CustomField.type \nFROM    step_attributes StepAttribute\n INNER JOIN custom_fields CustomField ON (CustomField.id = StepAttribute.custom_field_id)\n WHERE\n StepAttribute.id = :stepAttributeId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.String customFieldType(@org.jetbrains.annotations.Nullable
    java.lang.Integer stepAttributeId);
    
    @androidx.room.Query(value = "SELECT    * FROM    assigned_step_attributes  WHERE item_uuid = :uuid  AND assigned_checklist_uuid = :assignedChecklistUuid  AND checklist_element_id = :elementId  AND step_attribute_id = :stepAttributeId AND value = :value")
    @org.jetbrains.annotations.Nullable
    public abstract com.icarus.entities.AssignedStepAttributesEntity ifStepAttributeWithFileExists(@org.jetbrains.annotations.Nullable
    java.lang.String uuid, @org.jetbrains.annotations.Nullable
    java.lang.Integer elementId, @org.jetbrains.annotations.Nullable
    java.lang.String value, @org.jetbrains.annotations.Nullable
    java.lang.String assignedChecklistUuid, @org.jetbrains.annotations.Nullable
    java.lang.Integer stepAttributeId);
    
    @androidx.room.Query(value = "SELECT    * FROM    assigned_step_attributes  WHERE item_uuid = :uuid  AND assigned_checklist_uuid = :assignedChecklistUuid  AND checklist_element_id = :elementId  AND step_attribute_id = :stepAttributeId")
    @org.jetbrains.annotations.Nullable
    public abstract com.icarus.entities.AssignedStepAttributesEntity ifStepAttributeExists(@org.jetbrains.annotations.Nullable
    java.lang.String uuid, @org.jetbrains.annotations.Nullable
    java.lang.Integer elementId, @org.jetbrains.annotations.Nullable
    java.lang.String assignedChecklistUuid, @org.jetbrains.annotations.Nullable
    java.lang.Integer stepAttributeId);
    
    @androidx.room.Query(value = "SELECT \n    *\nFROM \n    assigned_ncw\nWHERE \n    assigned_checklist_uuid = :uuid \nAND checklist_element_id = :checkListElementID")
    @org.jetbrains.annotations.Nullable
    public abstract com.icarus.entities.AssignedNCWEntity ifNCWExists(@org.jetbrains.annotations.Nullable
    java.lang.String uuid, @org.jetbrains.annotations.Nullable
    java.lang.Integer checkListElementID);
    
    @androidx.room.Query(value = "SELECT \n    *\nFROM \n    assigned_decisions\nWHERE \n    assigned_checklist_uuid = :uuid \nAND checklist_element_id = :checkListElementID")
    @org.jetbrains.annotations.Nullable
    public abstract com.icarus.entities.AssignedDecisionEntity ifDecisionExists(@org.jetbrains.annotations.Nullable
    java.lang.String uuid, @org.jetbrains.annotations.Nullable
    java.lang.Integer checkListElementID);
    
    @androidx.room.Query(value = "SELECT    * FROM    assigned_steps WHERE    checklist_element_id = :stepId  AND assigned_checklist_uuid = :assignedChecklistUuid")
    @org.jetbrains.annotations.Nullable
    public abstract com.icarus.entities.AssignedStepEntity ifStepExists(@org.jetbrains.annotations.Nullable
    java.lang.String assignedChecklistUuid, @org.jetbrains.annotations.Nullable
    java.lang.Integer stepId);
    
    @androidx.room.Query(value = "SELECT \n    *\nFROM \n    assigned_checklists\nWHERE \n    uuid = :uuid")
    @org.jetbrains.annotations.Nullable
    public abstract com.icarus.entities.AssignCheckListEntity ifAssignedChecklistExists(@org.jetbrains.annotations.Nullable
    java.lang.String uuid);
    
    @androidx.room.Query(value = "SELECT \n    *\nFROM \n    assigned_logos\nWHERE \n    assigned_checklist_uuid = :uuid")
    @org.jetbrains.annotations.Nullable
    public abstract com.icarus.entities.AssignedLogoEntity ifAssignedLogoExists(@org.jetbrains.annotations.Nullable
    java.lang.String uuid);
    
    @androidx.room.Query(value = "SELECT \n    *\nFROM \n    assigned_room_equipments\nWHERE \n    assigned_checklist_uuid = :uuid")
    @org.jetbrains.annotations.Nullable
    public abstract com.icarus.entities.AssignRoomEquipmentsEntity ifAssignedRoomEquipmentExists(@org.jetbrains.annotations.Nullable
    java.lang.String uuid);
    
    @androidx.room.Query(value = "SELECT \n    *\nFROM \n    assigned_users\nWHERE \n    assigned_checklist_uuid = :uuid  AND user_id = :userId")
    @org.jetbrains.annotations.Nullable
    public abstract com.icarus.entities.AssignedUserEntity ifAssignedUserExists(@org.jetbrains.annotations.Nullable
    java.lang.String uuid, @org.jetbrains.annotations.Nullable
    java.lang.Integer userId);
    
    @androidx.room.Query(value = "SELECT \n    *\nFROM \n    assigned_departments\nWHERE \n    assigned_checklist_uuid = :uuid  AND department_id = :depId")
    @org.jetbrains.annotations.Nullable
    public abstract com.icarus.entities.AsssignedDepartmentsEntity ifAssignedDepartmentExists(@org.jetbrains.annotations.Nullable
    java.lang.String uuid, @org.jetbrains.annotations.Nullable
    java.lang.Integer depId);
    
    @androidx.room.Query(value = "SELECT \n    *\nFROM \n    user_favorites\nWHERE \n    checklist_id = :id  AND user_id = :userId")
    @org.jetbrains.annotations.Nullable
    public abstract com.icarus.entities.UserFavouritesEntity ifUserFavoriteExists(@org.jetbrains.annotations.Nullable
    java.lang.Integer id, @org.jetbrains.annotations.Nullable
    java.lang.Integer userId);
    
    @androidx.room.Query(value = "SELECT \n    *\nFROM \n    workorders\nWHERE \n    id = :workOrderId")
    @org.jetbrains.annotations.Nullable
    public abstract com.icarus.entities.WorkOrderEntity ifWorkOrderExists(@org.jetbrains.annotations.Nullable
    java.lang.Integer workOrderId);
    
    @androidx.room.Query(value = "SELECT \n    *\nFROM \n    workorders\nWHERE \n    uuid = :workOrderUuid")
    @org.jetbrains.annotations.Nullable
    public abstract com.icarus.entities.WorkOrderEntity workOrder(@org.jetbrains.annotations.Nullable
    java.lang.String workOrderUuid);
    
    @androidx.room.Query(value = "SELECT \n    *\nFROM \n    workorder_notes\nWHERE \n    uuid = :workOrderNoteUuid")
    @org.jetbrains.annotations.Nullable
    public abstract com.icarus.entities.WorkOrderNotesEntity workOrderNote(@org.jetbrains.annotations.Nullable
    java.lang.String workOrderNoteUuid);
    
    @androidx.room.Query(value = "SELECT \n    *\nFROM \n    workorder_note_details\nWHERE \n    uuid = :workOrderNoteDetailUuid")
    @org.jetbrains.annotations.Nullable
    public abstract com.icarus.entities.WorkOrderNoteDetailEntity workOrderNoteDetail(@org.jetbrains.annotations.Nullable
    java.lang.String workOrderNoteDetailUuid);
    
    @androidx.room.Query(value = "SELECT \n    *\nFROM \n    workorder_attachments\nWHERE \n    uuid = :workOrderAttachmentUuid")
    @org.jetbrains.annotations.Nullable
    public abstract com.icarus.entities.WorkOrderAttachmentsEntity workOrderAttachment(@org.jetbrains.annotations.Nullable
    java.lang.String workOrderAttachmentUuid);
    
    @androidx.room.Query(value = "SELECT \n    *\nFROM \n    location_rooms\nWHERE \n    id = :locationId")
    @org.jetbrains.annotations.Nullable
    public abstract com.icarus.entities.LocationRoomEntity ifLocationRoomExists(@org.jetbrains.annotations.Nullable
    java.lang.Integer locationId);
    
    @androidx.room.Query(value = "SELECT \n    *\nFROM \n    location_equipments\nWHERE \n    id = :locationId")
    @org.jetbrains.annotations.Nullable
    public abstract com.icarus.entities.LocationEquipmentsEntity ifLocationEquipmentExists(@org.jetbrains.annotations.Nullable
    java.lang.Integer locationId);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract void insertLocationRooms(@org.jetbrains.annotations.Nullable
    com.icarus.entities.LocationRoomEntity locationRoomEntity);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract void insertLocationEquipment(@org.jetbrains.annotations.Nullable
    com.icarus.entities.LocationEquipmentsEntity locationEquipmentsEntity);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract void insertQRStorage(@org.jetbrains.annotations.Nullable
    com.icarus.entities.QRStorageEntity qrStorageEntity);
    
    @androidx.room.Query(value = "delete FROM qr_storage where id =:qrStorageID")
    public abstract void deleteQRStorage(@org.jetbrains.annotations.Nullable
    java.lang.Integer qrStorageID);
    
    @androidx.room.Query(value = "Select * From assigned_checklists where uuid = :checklistUuid")
    @org.jetbrains.annotations.Nullable
    public abstract com.icarus.entities.AssignCheckListEntity getAssignedChecklist(@org.jetbrains.annotations.Nullable
    java.lang.String checklistUuid);
    
    @androidx.room.Query(value = "delete FROM workorder_attachments where uuid = :oldId and sync_status = 0")
    public abstract void deleteSyncedWorkorderAttachment(@org.jetbrains.annotations.Nullable
    java.lang.String oldId);
    
    @androidx.room.Query(value = "delete FROM workorder_note_details where id = :oldId")
    public abstract void deleteSyncedWorkorderNoteDetail(@org.jetbrains.annotations.Nullable
    java.lang.Integer oldId);
    
    @androidx.room.Query(value = "delete FROM workorder_notes where id = :oldId")
    public abstract void deleteSyncedWorkorderNote(@org.jetbrains.annotations.Nullable
    java.lang.Integer oldId);
    
    @androidx.room.Query(value = "delete FROM workorders where id = :oldId")
    public abstract void deleteSyncedWorkorder(@org.jetbrains.annotations.Nullable
    java.lang.Integer oldId);
    
    @androidx.room.Transaction
    public abstract void insertChecklistAssociatedData(@org.jetbrains.annotations.Nullable
    com.icarus.entities.AllChecklistEntity checklist, @org.jetbrains.annotations.Nullable
    com.icarus.entities.CheckListTitlesEntity checklistTitle, @org.jetbrains.annotations.NotNull
    java.util.List<? extends com.icarus.entities.CheckListLogoEntity> checklistLogos);
    
    @androidx.room.Transaction
    public abstract void saveWorkOrder(@org.jetbrains.annotations.NotNull
    com.icarus.entities.WorkOrderEntity workOrderEntity, @org.jetbrains.annotations.NotNull
    java.util.List<? extends com.icarus.entities.WorkOrderNotesEntity> workOrderNoteEntities, @org.jetbrains.annotations.NotNull
    java.util.List<? extends com.icarus.entities.WorkOrderNoteDetailEntity> workOrderNoteDetailEntities, @org.jetbrains.annotations.NotNull
    java.util.List<? extends com.icarus.entities.WorkOrderAttachmentsEntity> workOrderAttachmentEntities);
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
        
        @androidx.room.Transaction
        public static void insertLocationsWithAssociatedData(@org.jetbrains.annotations.NotNull
        com.icarus.dao.GetSynchronizationDaoKot $this, @org.jetbrains.annotations.NotNull
        java.util.List<? extends com.icarus.entities.LocationEntity> locationEntities, @org.jetbrains.annotations.Nullable
        java.util.List<? extends com.icarus.entities.LocationDepartmentsEntity> locationDepartmentsEntities) {
        }
        
        @androidx.room.Transaction
        public static void insertChecklistAssociatedData(@org.jetbrains.annotations.NotNull
        com.icarus.dao.GetSynchronizationDaoKot $this, @org.jetbrains.annotations.Nullable
        com.icarus.entities.AllChecklistEntity checklist, @org.jetbrains.annotations.Nullable
        com.icarus.entities.CheckListTitlesEntity checklistTitle, @org.jetbrains.annotations.NotNull
        java.util.List<? extends com.icarus.entities.CheckListLogoEntity> checklistLogos) {
        }
        
        @androidx.room.Transaction
        public static void saveWorkOrder(@org.jetbrains.annotations.NotNull
        com.icarus.dao.GetSynchronizationDaoKot $this, @org.jetbrains.annotations.NotNull
        com.icarus.entities.WorkOrderEntity workOrderEntity, @org.jetbrains.annotations.NotNull
        java.util.List<? extends com.icarus.entities.WorkOrderNotesEntity> workOrderNoteEntities, @org.jetbrains.annotations.NotNull
        java.util.List<? extends com.icarus.entities.WorkOrderNoteDetailEntity> workOrderNoteDetailEntities, @org.jetbrains.annotations.NotNull
        java.util.List<? extends com.icarus.entities.WorkOrderAttachmentsEntity> workOrderAttachmentEntities) {
        }
    }
}